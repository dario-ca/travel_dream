package it.travelDream.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-22T22:20:00.825+0100")
@StaticMetamodel(PurchasedPackage.class)
public class PurchasedPackage_ {
	public static volatile SingularAttribute<PurchasedPackage, Integer> idPurchasedPackage;
	public static volatile SingularAttribute<PurchasedPackage, User> user;
	public static volatile SingularAttribute<PurchasedPackage, PackageTd> packageTd;
	public static volatile SingularAttribute<PurchasedPackage, Integer> totPrice;
	public static volatile SingularAttribute<PurchasedPackage, Integer> numPeople;
}
