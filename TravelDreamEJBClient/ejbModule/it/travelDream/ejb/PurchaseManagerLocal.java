package it.travelDream.ejb;

import java.util.ArrayList;

import it.travelDream.ejb.dto.PurchasedPackageDTO;

public interface PurchaseManagerLocal {
    public void buy(PurchasedPackageDTO packageBought);
    public ArrayList<PurchasedPackageDTO> allUserPurchasedPackages();

}
