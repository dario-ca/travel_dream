package it.travelDream.entities;

import it.travelDream.ejb.GroupType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-18T21:26:18.215+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile ListAttribute<User, GroupType> groups;
}
