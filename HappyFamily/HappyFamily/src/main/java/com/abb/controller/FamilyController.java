package com.abb.controller;

import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.model.Pet;
import com.abb.service.FamilyService;

import java.util.List;

public class FamilyController
{
    private static FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies ()
    {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies ()
    {
        familyService.displayAllFamilies();
    }

    public void getFamiliesBiggerThan (int numberOfPeople)
    {
        familyService.getFamiliesBiggerThan(numberOfPeople);
    }

    public void getFamiliesLessThan (int numberOfPeople)
    {
        familyService.getFamiliesLessThan(numberOfPeople);
    }

    public int countFamiliesWithMemberNumber (int numberOfPeople)
    {
        return familyService.countFamiliesWithMemberNumber(numberOfPeople);
    }

    public void createNewFamily (Human father, Human mother)
    {
        familyService.createNewFamily(father, mother);
    }

    public boolean deleteFamilyByIndex (int index)
    {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild (Family family, String type)
    {
        return familyService.bornChild(family, type);
    }

    public Family adoptChild (Family family, Human child)
    {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan (int age)
    {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count ()
    {
        return familyService.count();
    }

    public Family getFamilyById (int index)
    {
        return familyService.getFamilyById(index);
    }

    public List<Pet> getPets (int index)
    {
        return familyService.getPets(index);
    }

    public void addPet (int index, Pet pet)
    {
        familyService.addPet(index, pet);
    }
}
