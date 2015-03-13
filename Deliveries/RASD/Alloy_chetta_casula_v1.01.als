//++++++++++++++++++++++++++++++++++++++++++++Valori predefiniti dello stato del pacchetto

enum Status {AVAILABLE, NOT_AVAILABLE}

//++++++++++++++++++++++++++++++++++++++++++++Tipi di dato

sig Email{}
sig PersonalCode{}
sig PackageID{}
sig ProductID{}
sig PackageStatus in Status{}
sig BasicProductStatus in Status{}

//++++++++++++++++++++++++++++++++++++++++++++Entità

sig RegisteredUser {
	eMail: one Email
}

sig Employee {
	personalCode: one PersonalCode 
}

sig Package {
	packageID: one PackageID,
	packageStatus: one PackageStatus,
	transportationMean: one TransportationMean,
	accommodation: one Accommodation,
	trip: set Trip,
	//availablePlaces: Int
}{/*availablePlaces >= 0*/}

abstract sig BasicProduct {
	/*productID: one ProductID,*/
	basicProductStatus: one BasicProductStatus
}

sig TransportationMean extends BasicProduct{transID: one ProductID}

sig Trip extends BasicProduct{tripID: one ProductID}

sig Accommodation extends BasicProduct{accID: one ProductID}

sig WishList{
	owner: one RegisteredUser,
	packageContained: set Package
}

//++++++++++++++++++++++++++++++++++++++++++++Fatti

//Non esistono due pacchetti con lo stesso ID

fact noSamePackageID {
	no disj p1,p2: Package | (p1.packageID = p2.packageID)
}

//Non esistono due utenti con la stessa mail

fact noSameMail {
	no disj u1,u2: RegisteredUser | (u1.eMail = u2.eMail)
}

//Un pacchetto non può essere AVAILABLE e NOT_AVAILABLE contemporaneamente

fact noStatusContradiction {
	all p: Package | (p.packageStatus != AVAILABLE or p.packageStatus != NOT_AVAILABLE)
}

//Un prodotto base non può essere AVAILABLE e NOT_AVAILABLE contemporaneamente

fact noStatusContradiction {
	all b: BasicProduct | (b.basicProductStatus != AVAILABLE or b.basicProductStatus != NOT_AVAILABLE)
}

/*
//Non esistono due prodotti base con lo stesso ID

fact noSameProductID {
	no disj bp1,bp2: BasicProduct | (bp1.productID = bp2.productID)
}
*/

//Non esistono due TransportationMean con lo stesso ID

fact noSameTransID {
	no disj tr1,tr2: TransportationMean | (tr1.transID = tr2.transID)
}

//Non esistono due Accommodation con lo stesso ID

fact noSameAccID {
	no disj acc1,acc2: Accommodation | (acc1.accID = acc2.accID)
}

//Non esistono due Trip con lo stesso ID

fact noSameTripID {
	no disj trip1,trip2: Trip | (trip1.tripID = trip2.tripID)
}

//Non esistono due impiagati con lo stesso codice personale

fact noSamePersonalCode{
	no disj e1,e2:Employee | e1.personalCode = e2.personalCode
}

/*
//Se un pacchetto non ha più posti disponibili allora è NOT_AVAILABLE

fact noAvailablePlaces{
	all p:Package | p.availablePlaces = 0 implies p.packageStatus = NOT_AVAILABLE
}
*/

//Un pacchetto disponibile non può contenere prodotti base non disponibili

fact noNotAvailableProductsInAvailablePackages{
	all p:Package | all b:BasicProduct |
						 (p.packageStatus=AVAILABLE and
											(b=p.accommodation or b=p.transportationMean or (b in p.trip) ) )
																					 			implies (b.basicProductStatus=AVAILABLE)
}

//Non esistono due WishList con lo stesso proprietario

fact noSameWishListOwner{
	no disj w1,w2:WishList | w1.owner = w2.owner
}

//Tutte le email hanno un utente cui si riferiscono

fact noEmailWithoutUser{
	all e:Email | one u:RegisteredUser | u.eMail = e
}

//Tutti i packageID hanno un pacchetto cui si riferiscono

fact noPackageIDWithoutPackage{
	all pid:PackageID | one p:Package | p.packageID = pid
}

/*
//Tutti i productID hanno un prodotto base cui si riferiscono

fact noProductIDWithoutBasicProduct{
	all bpid:ProductID | one b:BasicProduct | b.productID = bpid
}
*/

//Tutti i personalCode hanno un impiegato cui si riferiscono

fact noPersonalCodeWithoutEmployee{
	all pc:PersonalCode | one e:Employee | e.personalCode = pc
}

//++++++++++++++++++++++++++++++++++++++++++++Predicato visualizzatore

pred show(){
#Employee = 1
#WishList = 3
#Trip > 0
some p:Package | p.packageStatus = AVAILABLE
}
run show

//++++++++++++++++++++++++++++++++++++++++++++Asserzioni

//Verifichiamo che non esistono due pacchetti con lo stesso ID

assert noSamePackageIDAssertion {no disj p1,p2 :Package | (p1.packageID = p2.packageID)}
check noSamePackageIDAssertion

//Verifichiamo che non esistono due utenti con la stessa mail

assert noSameMailAssertion{no disj u1,u2:RegisteredUser | (u1.eMail = u2.eMail)}
check noSameMailAssertion

//Verifichiamo che un pacchetto non può essere disponibile e non disponibile contemporaneamente

assert noPackageStatusContradictionAssertion {no p:Package | (p.packageStatus = AVAILABLE and p.packageStatus=NOT_AVAILABLE)}
check noPackageStatusContradictionAssertion

//Verifichiamo che un prodotto base non può essere disponibile e non disponibile contemporaneamente

assert noBasicProductStatusContradictionAssertion {no b:BasicProduct | (b.basicProductStatus = AVAILABLE and b.basicProductStatus=NOT_AVAILABLE)}
check noBasicProductStatusContradictionAssertion

/*
//Verifichiamo che non esistono due prodotti base con lo stesso ID

assert noSameProductIDAssertion{no disj bp1,bp2:BasicProduct | bp1.productID = bp2.productID}
check noSameProductIDAssertion
*/

//Verifichiamo che non esistono due TransportationMean con lo stesso ID

assert noSameTransIDAssertion{no disj tr1,tr2:TransportationMean | tr1.transID = tr2.transID}
check noSameTransIDAssertion

//Verifichiamo che non esistono due Accommodation con lo stesso ID

assert noSameAccIDAssertion{no disj acc1,acc2:Accommodation | acc1.accID = acc2.accID}
check noSameAccIDAssertion

//Verifichiamo che non esistono due Trip con lo stesso ID

assert noSameTripIDAssertion{no disj trip1,trip2:Trip | trip1.tripID = trip2.tripID}
check noSameTripIDAssertion

//Verifichiamo che non esistono due impiegati con lo stesso codice personale

assert noSamePersonalCodeAssertion {no disj e1,e2:Employee | e1.personalCode = e2.personalCode}
check noSamePersonalCodeAssertion

/*
//Non esistono pacchetti senza posti disponibili che non siano NOT_AVAILABLE

assert noAvailablePlacesAssertion {no p:Package | p.availablePlaces = 0 and p.packageStatus != NOT_AVAILABLE}
check noAvailablePlacesAssertion
*/

//Non esistono pacchetti disponibili comprendenti prodotti base non disponibili

assert noNotAvailableProductsInAvailablePackagesAssertion{
											no p:Package | some b:BasicProduct |
														 (p.packageStatus=AVAILABLE and
																(p.accommodation = b or p.transportationMean = b or (b in p.trip) ))
																				 										and (b.basicProductStatus=NOT_AVAILABLE)}
check noNotAvailableProductsInAvailablePackagesAssertion

//Due WishList non possono avere lo stesso proprietario

assert noSameWishListOwnerAssertion{	no disj w1,w2:WishList | w1.owner = w2.owner}
check noSameWishListOwnerAssertion
