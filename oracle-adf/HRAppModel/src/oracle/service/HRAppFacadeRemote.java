package oracle.service;

import java.util.List;
import javax.ejb.Remote;
import model.Department;
import model.Employee;
import model.Location;


/**
 * @generated DT_ID=none
 */
@Remote
public interface HRAppFacadeRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Department persistDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public Department mergeDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public void removeDepartment(Department department);

    /**
     * @generated DT_ID=none
     */
    public List<Department> getDepartmentFindAll();

    /**
     * @generated DT_ID=none
     */
    public Employee persistEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public Employee mergeEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public void removeEmployee(Employee employee);

    /**
     * @generated DT_ID=none
     */
    public List<Employee> getEmployeeFindAll();

    /**
     * @generated DT_ID=none
     */
    public List<Employee> getEmployeesFindBySal(java.math.BigDecimal p_sal);

    /**
     * @generated DT_ID=none
     */
    public Location persistLocation(Location location);

    /**
     * @generated DT_ID=none
     */
    public Location mergeLocation(Location location);

    /**
     * @generated DT_ID=none
     */
    public void removeLocation(Location location);

    /**
     * @generated DT_ID=none
     */
    public List<Location> getLocationFindAll();

}
