package it.travelDream.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-13T20:58:00.448+0100")
@StaticMetamodel(TransportationMean.class)
public class TransportationMean_ {
	public static volatile SingularAttribute<TransportationMean, Integer> idTransportation;
	public static volatile SingularAttribute<TransportationMean, String> name;
	public static volatile SingularAttribute<TransportationMean, Double> price;
	public static volatile SingularAttribute<TransportationMean, Date> departureDate;
	public static volatile SingularAttribute<TransportationMean, Date> arrivalDate;
	public static volatile SingularAttribute<TransportationMean, String> notes;
	public static volatile SingularAttribute<TransportationMean, Boolean> status;
	public static volatile ListAttribute<TransportationMean, PackageTd> packageTds;
}
