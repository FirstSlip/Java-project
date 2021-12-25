package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class OffersOperations {
    private ArrayList<Offer> offersList = new ArrayList<>();

    OffersOperations() {

    }

    OffersOperations(String path) throws IOException, ParseException {
        setOffersList(path);
    }

    public void setOffersList(String path) throws IOException, ParseException {
        File file = new File(path);
        BufferedReader in = new BufferedReader(new FileReader(file));
        in.readLine();
        String line;
        int ID = 0;
        while ((line = in.readLine()) != null) {
            offersList.add(new Offer(line, ID));
            ID++;
        }

    }

    public ArrayList<Offer> getOffersList() {
        return offersList;
    }
}
