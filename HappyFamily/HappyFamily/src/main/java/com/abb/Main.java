package com.abb;

import com.abb.controller.FamilyController;
import com.abb.enums.Species;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.model.Pet;

public class Main
{
    public static void main (String[] args)
    {
        Human father1 = new Human("Tom", "Carlson", 1971);
        Human father2 = new Human("Noah", "Jackson", 1974);
        Human mother1 = new Human("Olivia", "Carlson", 1975);
        Human mother2 = new Human("Sophia", "Jackson", 1980);
        Human child1 = new Human("Emma", "Carlson", 2000);
        Human child2 = new Human("Olivier", "Carlson", 2005);
        Human child3 = new Human("Amelia", "Jackson", 2004);
        Human child4 = new Human("James", "Jackson", 2001);
        Human child5 = new Human("Lucas", "Jackson", 2001);

        Pet pet1 = new Pet(Species.DOG, "Max");
        Pet pet2 = new Pet(Species.DOG, "Luna");

        Family family1 = new Family(mother1, father1);
        Family family2 = new Family(mother2, father2);

        family1.addChild(child1);
        family1.addChild(child2);
        family2.addChild(child3);
        family2.addChild(child4);
        family2.addChild(child5);

        FamilyController familyController = new FamilyController();

        System.out.println("Firstly we call getAllFamilies method, but we have not add any family yet, so it have to " +
                "return empty list.");
        System.out.println(familyController.getAllFamilies());
        breakLine();

        System.out.println("We call createNewFamily method and create new families, so add them to list...");
        System.out.println("Father 1: " + father1);
        System.out.println("Mother 1: " + mother1);
        System.out.println("Father 2: " + father2);
        System.out.println("Mother 2: " + mother2);
        familyController.createNewFamily(father1, mother1);
        familyController.createNewFamily(father2, mother2);
        breakLine();

        System.out.println("After that, we call again getAllFamilies method..");
        System.out.println(familyController.getAllFamilies());
        breakLine();

        System.out.println("Call displayAllFamilies method...");
        familyController.displayAllFamilies();
        breakLine();

        System.out.println("We add children to families with adoptChild method...");
        System.out.println("Child 1: " + child1);
        System.out.println("Child 2: " + child2);
        System.out.println("Child 3: " + child3);
        System.out.println("Child 4: " + child4);
        System.out.println("Child 5: " + child5);
        familyController.adoptChild(family1, child1);
        familyController.adoptChild(family1, child2);
        familyController.adoptChild(family2, child3);
        familyController.adoptChild(family2, child4);
        familyController.adoptChild(family2, child5);
        breakLine();

        System.out.println("Again call displayAllFamilies method...");
        familyController.displayAllFamilies();
        breakLine();

        System.out.println("Call bornChild method...");
        System.out.println("Family: " + family1);
        System.out.println("Type: masculine");
        familyController.bornChild(family1, "masculine");
        breakLine();

        System.out.println("Again call displayAllFamilies...");
        familyController.displayAllFamilies();
        breakLine();

        System.out.println("Call getFamiliesBiggerThan with numberOfPeople 4...");
        familyController.getFamiliesBiggerThan(4);
        breakLine();

        System.out.println("Call getFamiliesLessThan with numberOfPeople 6...");
        familyController.getFamiliesLessThan(6);
        breakLine();

        System.out.println("Call countFamiliesWithMemberNumber method with numberOfPeople 5...");
        System.out.println(familyController.countFamiliesWithMemberNumber(5));
        breakLine();

        System.out.println("Calling count method...");
        System.out.println(familyController.count());
        breakLine();

        System.out.println("Calling getFamilyById method with index: 1...");
        System.out.println(familyController.getFamilyById(1));
        breakLine();

        System.out.println("Calling deleteAllChildrenOlderThan method with age: 18...");
        System.out.println("Before calling method.");
        familyController.displayAllFamilies();
        familyController.deleteAllChildrenOlderThan(18);
        System.out.println("After calling method.");
        familyController.displayAllFamilies();
        breakLine();

        System.out.println("Calling deleteFamilyByIndex with index: 1...");
        System.out.println("Before calling method.");
        familyController.displayAllFamilies();
        boolean deleteFamilyByIndex = familyController.deleteFamilyByIndex(1);
        System.out.println("After calling method.");
        familyController.displayAllFamilies();
        System.out.println("Result of method: " + deleteFamilyByIndex);
        breakLine();

        System.out.println("Calling addPet method to family in index 0...");
        System.out.println("Pet 1: " + pet1);
        System.out.println("Pet 2: " + pet2);
        familyController.addPet(0, pet1);
        familyController.addPet(0, pet2);
        familyController.displayAllFamilies();
        breakLine();

        System.out.println("Calling getPets method with index 0...");
        System.out.println(familyController.getPets(0));
        breakLine();
    }

    private static void breakLine ()
    {
        System.out.println("*******************************************************");
    }
}