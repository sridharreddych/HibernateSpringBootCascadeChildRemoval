package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    
    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }        

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {            
            // System.out.println("\n\n deleteViaCascadeRemove()");
            // bookstoreService.deleteViaCascadeRemove();
            
            // System.out.println("\n\n deleteViaOrphanRemoval()");
            // bookstoreService.deleteViaOrphanRemoval();
            
            // System.out.println("\n\n deleteViaIdentifiers()");
            // bookstoreService.deleteViaIdentifiers();
            
            // System.out.println("\n\n deleteViaIdentifiersX()");
            // bookstoreService.deleteViaIdentifiersX();                                    
                        
             System.out.println("\n\n deleteViaBulkIn()");
             bookstoreService.deleteViaBulkIn();
             
             // System.out.println("\n\n deleteViaBulkInX()");
             // bookstoreService.deleteViaBulkInX();
            
             // System.out.println("\n\n deleteViaHardCodedIdentifiers()");
             // bookstoreService.deleteViaHardCodedIdentifiers();
             
             // System.out.println("\n\n deleteViaBulkHardCodedIdentifiers()");
             // bookstoreService.deleteViaBulkHardCodedIdentifiers();
        };
    }
}

/*
 * The Best Way To Remove Parent And Child Entities

Description: Commonly, deleting a parent and the associated children via CascadeType.REMOVE and/or orphanRemoval=true involved several SQL statements (e.g., each child is deleted in a dedicated DELETE statement). When the number of entities is significant, this is far from being efficient, therefore other approaches should be employed.

Consider Author and Book in a bidirectional-lazy @OneToMany association. This application exposes the best way to delete the parent(s) and the associated children in four scenarios listed below.

Best way to delete author(s) and the associated books when:

One Author is in Persistent Context, no Book
More Author are in the Persistent Context, no Book
One Author and the associated Book are in Persistent Context
No Author or Book is in Persistent Context
Note: The most efficient way to delete all entities can be done via the built-in deleteAllInBatch().


 */
