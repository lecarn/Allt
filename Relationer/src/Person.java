public class Person {

  // -- Private Variables
  private int id;
  private String fullName;
  private Company company;
  private boolean isMarried;

  // -- Constructors

  /**
   * Constructor that creates a Person with an ID and a name.
   * @param id being the ID to specify
   * @param fullName being the name of the person.
   */
  public Person(int id, String fullName) {
    this.id = id;
    this.fullName = fullName;
    isMarried = false;
  }

  /**
   * Constructor that creates a Person with an ID, name and a company (OBJECT).
   * @param id being the ID to specify
   * @param fullName being the name of the person
   * @param company being the OBJECT company {@link Company}
   */
  public Person(int id, String fullName, Company company) {
    this.id = id;
    this.fullName = fullName;
    this.company = company;
  }

  /**
   * Sets the persons married status to true.
   * (Not a normal type of Setter. An abstract example
   */
  public void isNowMarried() {
    isMarried = true;
  }

  /**
   * Sets the persons married status to false.
   * (Not a normal type of Setter. An abstract example
   */
  public void isNowDivorced() {
    isMarried = false;
  }

  /**
   * Gets the full name of the person
   * @return the String fullName
   */
  public String getFullName(){
    return fullName;
  }

  /**
   * Gets the ID of the person
   * @return the ID of the person.
   */
  public int getId() {
    return id;
  }

  /**
   * Checks if the person is married.
   * @return true if the person is married or not.
   */
  public boolean isMarried() {
    return isMarried;
  }

  /**
   * This returns the OBJECT Company that is related to the Person.
   * {@link Company}
   * @return the Company associated with the Person
   */
  public Company getCompany() {
    return company;
  }

  /**
   * Sets the company, inparameter being the object {@link Company} to be
   * associated with the Person
   * @param theCompany the Company to relate to the person.
   */
  public void setCompany(Company theCompany) {
    company = theCompany;
  }
}
