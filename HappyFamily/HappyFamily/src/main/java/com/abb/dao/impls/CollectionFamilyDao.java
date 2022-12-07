package com.abb.dao.impls;

import com.abb.dao.FamilyDao;
import com.abb.model.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao
{
    private static List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies ()
    {
        return families;
    }

    @Override
    public Family getFamilyByIndex (int index)
    {
        if (index >= families.size())
            return null;

        return families.get(index);
    }

    @Override
    public Boolean deleteFamily (int index)
    {
        if (index >= families.size())
            return false;

        families.remove(index);

        return true;
    }

    @Override
    public Boolean deleteFamily (Family family)
    {
        if (!families.contains(family))
            return false;

        families.remove(family);

        return true;
    }

    @Override
    public void saveFamily (Family family)
    {
        if (families.contains(family))
        {
            Family oldFamily = families.get(families.indexOf(family));
            updateFamily(oldFamily, family);
            return;
        }

        families.add(family);
    }

    private void updateFamily (Family oldFamily, Family newFamily)
    {
        oldFamily.setFather(newFamily.getFather());
        oldFamily.setMother(newFamily.getMother());
        oldFamily.setChildren(newFamily.getChildren());
        oldFamily.setPet(newFamily.getPet());
    }
}
