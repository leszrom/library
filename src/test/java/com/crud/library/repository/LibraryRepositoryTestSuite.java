package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.Loan;
import com.crud.library.domain.User;
import com.crud.library.domain.Volume;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryRepositoryTestSuite {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private VolumeRepository volumeRepository;

    @Test
    public void should_persist_users_books_volumes_and_loans_in_database() {
        //Given
        User johnSmith = new User("John", "Smith");
        User aliceBow = new User("Alice", "Bow");

        Book blueFlowers = new Book("Blue Flower", "Michael Gill", LocalDate.parse("2014-09-12"));
        Book runway = new Book("Runway", "Ben Slow", LocalDate.parse("1998-01-30"));

        Volume blueFlowersVolumeFirst = new Volume(blueFlowers, false);
        Volume blueFlowersVolumeSecond = new Volume(blueFlowers, false);
        Volume runwayVolumeFirst = new Volume(runway, false);
        Volume runwayVolumeSecond = new Volume(runway, false);

        blueFlowers.getVolumes().add(blueFlowersVolumeFirst);
        blueFlowers.getVolumes().add(blueFlowersVolumeSecond);
        runway.getVolumes().add(runwayVolumeFirst);
        runway.getVolumes().add(runwayVolumeSecond);

        Loan smithLoansFlowersFirst = new Loan(johnSmith, blueFlowersVolumeFirst);
        Loan smithLoansRunway = new Loan(johnSmith, runwayVolumeFirst);
        Loan bowLoansFlowersSecond = new Loan(aliceBow, blueFlowersVolumeSecond);

        blueFlowersVolumeFirst.setRented(true);
        runwayVolumeFirst.setRented(true);
        blueFlowersVolumeSecond.setRented(true);

        johnSmith.getLoans().add(smithLoansFlowersFirst);
        johnSmith.getLoans().add(smithLoansRunway);
        aliceBow.getLoans().add(bowLoansFlowersSecond);

        //When
        bookRepository.save(blueFlowers);
        bookRepository.save(runway);
        userRepository.save(johnSmith);
        userRepository.save(aliceBow);

        long smithId = johnSmith.getId();
        long bowId = aliceBow.getId();
        int smithLoans = johnSmith.getLoans().size();
        int bowLoans = aliceBow.getLoans().size();

        long blueFlowersId = blueFlowers.getId();
        long runwayId = runway.getId();
        int blueFlowersVolumes = blueFlowers.getVolumes().size();
        int runwayVolumes = runway.getVolumes().size();

        int smithLoansRead = loanRepository.findAllByUserId(smithId).size();
        int bowLoansRead = loanRepository.findAllByUserId(bowId).size();

        int blueFlowersVolumesRead = volumeRepository.findAllByBookId(blueFlowersId).size();
        int runwayVolumesRead = volumeRepository.findAllByBookId(runwayId).size();

        //Then
        Assert.assertEquals(smithLoans, smithLoansRead);
        Assert.assertEquals(bowLoans, bowLoansRead);
        Assert.assertEquals(blueFlowersVolumes, blueFlowersVolumesRead);
        Assert.assertEquals(runwayVolumes, runwayVolumesRead);

        //CleanUp
        userRepository.delete(johnSmith);
        userRepository.delete(aliceBow);
        bookRepository.delete(blueFlowers);
        bookRepository.delete(runway);
    }
}