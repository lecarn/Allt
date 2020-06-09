import java.util.List;

public class Company {

  // -- Private Fields
  private String companyName;
  private List<Person> personList;

  // -- Constructors
  /**
   * Empty Constructor
   */
  public Company() {

  }

  /**
   * Constructor that takes a name and a list of person/people.
   * @param companyName - specifies the name of the company
   * @param personList - List of people. Add a list of people that you define before making
   * this constructor. Person,  is an OBJECT {@link Person}
   */
  public Company(String companyName, List<Person> personList) {
    this.companyName = companyName;
    this.personList = personList;
  }

  /**
   * Sets the companies name, send in the name of the company to specify it.
   * @param companyName being the name you want for the company.
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * Returns the company name
   * @return the String of the company's name.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * Gets an ARRAY list of the object Person within the Company.
   * This only returns a list of the person objects that has been added to the
   * company.
   * @return a list of persons.
   */
  public List<Person> getPersonList() {
    return personList;
  }
}
