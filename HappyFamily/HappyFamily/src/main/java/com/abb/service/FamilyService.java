package com.abb.service;

import com.abb.dao.FamilyDao;
import com.abb.dao.impls.CollectionFamilyDao;
import com.abb.model.Family;
import com.abb.model.Human;
import com.abb.model.Pet;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class FamilyService
{
    private static FamilyDao familyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies ()
    {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies ()
    {
        List<Family> families = familyDao.getAllFamilies();

        System.out.println(families);
    }

    public void getFamiliesBiggerThan (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        for (Family family : families)
            if (family.countFamily() > numberOfPeople)
                System.out.println(family);
    }

    public void getFamiliesLessThan (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        for (Family family : families)
            if (family.countFamily() < numberOfPeople)
                System.out.println(family);
    }

    public int countFamiliesWithMemberNumber (int numberOfPeople)
    {
        List<Family> families = familyDao.getAllFamilies();

        int count = 0;
        for (Family family : families)
            if (family.countFamily() == numberOfPeople)
                count++;

        return count;
    }

    public void createNewFamily (Human father, Human mother)
    {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex (int index)
    {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild (Family family, String type)
    {
        Human child = new Human();
        child.setSurname(family.getFather().getSurname());
        child.setYear(Integer.valueOf(Year.now().toString()));
        if (type.equals("masculine"))
            child.setName("Jake");
        else
            child.setName("Jasmin");

        family.addChild(child);

        familyDao.saveFamily(family);

        return family;
    }

    public Family adoptChild (Family family, Human child)
    {
        familyDao.getFamilyByIndex(familyDao.getAllFamilies().indexOf(family)).addChild(child);

        return family;
    }

    public void deleteAllChildrenOlderThan (int age)
    {
        List<Family> families = familyDao.getAllFamilies();

        for (Family family : families)
        {
            List<Human> children = family.getChildren();
            children.removeIf(child -> Integer.parseInt(Year.now().toString()) - child.getYear() > age);
        }
    }

    public int count ()
    {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById (int index)
    {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets (int index)
    {
        Family family = familyDao.getFamilyByIndex(index);

        return new ArrayList<>(family.getPet());
    }

    public void addPet (int index, Pet pet)
    {
        Family family = familyDao.getFamilyByIndex(index);

        family.getPet().add(pet);
    }
}
