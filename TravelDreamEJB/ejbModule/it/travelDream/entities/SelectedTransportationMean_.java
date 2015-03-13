package it.travelDream.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-11T14:31:30.280+0100")
@StaticMetamodel(SelectedTransportationMean.class)
public class SelectedTransportationMean_ {
	public static volatile SingularAttribute<SelectedTransportationMean, Integer> idSelectedTransportation;
	public static volatile SingularAttribute<SelectedTransportationMean, PackageTd> packageId;
	public static volatile SingularAttribute<SelectedTransportationMean, TransportationMean> transportationMeanId;
}
