package employeeController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.EmployeeDAO;
import model.FundDAO;
import model.Model;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.Fund;
import formbeans.CreateF;
public class CreateFund extends Action {
	private FormBeanFactory<CreateF> formBeanFactory = FormBeanFactory.getInstance(CreateF.class);
	private EmployeeDAO employeeDAO;
	private FundDAO fundDAO;
	
	public CreateFund(Model model) {
		employeeDAO = model.getEmployeeDAO();
		fundDAO = model.getFundDAO();
	}

	public String getName() { return "creatfund.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);

        try {
	        CreateF form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) {
	        	return "creatfund.do";
	        }
	
	        Fund fund = new Fund();
	        fund.setName(form.getfundName());
	        fund.setSymbol(form.getfundSym());
	        if (form.getAction().equals("Creat Fund")) {
        		fundDAO.create(fund);
        	} else {
        		errors.add("Invalid action: " + form.getAction());
        	}
			return "creat_fund.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
