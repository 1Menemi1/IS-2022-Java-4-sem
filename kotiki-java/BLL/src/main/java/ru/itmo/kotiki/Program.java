package ru.itmo.kotiki;

import ru.itmo.kotiki.model.Cat;
import ru.itmo.kotiki.model.Color;
import ru.itmo.kotiki.model.Owner;
import ru.itmo.kotiki.model.Type;

import java.sql.Date;

public class Program {
    public static void main(String[] args) {
        CatService catService = new CatService();
        OwnerService ownerService = new OwnerService();

        Owner owner = new Owner("Danya", Date.valueOf("2002-10-12"));
        ownerService.saveOwner(owner);

        Cat cat1 = new Cat("Kotyara", Date.valueOf("2002-10-12"), Type.Asian, Color.Red);
        Cat cat2 = new Cat("Kisik", Date.valueOf("2002-11-13"), Type.Korean, Color.Black);

        owner.addPet(cat1);
        owner.addPet(cat2);

        ownerService.removeCat(owner, cat1);

        ownerService.updateOwner(owner);
    }
}