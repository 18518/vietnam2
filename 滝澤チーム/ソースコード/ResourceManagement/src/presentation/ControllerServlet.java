package presentation;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.CommandException;
import dto.ErrorDTO;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {//ControllerServlet ke thua thau tu  HttpServlet



	private HashMap<String,Command> commands;

	public ControllerServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nextPage = null;

		// リクエストパラメータの文字コード指定
	    request.setCharacterEncoding("UTF-8");//set character cho request

	    try {

	    	String commandKey = request.getParameter("COMMAND");
			Command command = lookupCommand(commandKey);

		    nextPage = command.execute(request,response);

	    	System.out.println(commandKey);

	    }
	    catch(CommandException | SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
	    	// ログを表示する
	    	e.printStackTrace();

	    	// エラーページの遷移先を指定する
	    	nextPage = "/error.jsp";

	    	// コマンドで例外が発生した場合、エラービーンを作成してメッセージをセットする
	    	ErrorDTO errorbean = new ErrorDTO();
	    	errorbean.setMessage(e.getMessage());
	    	// エラービーンをパラメータへセットする
	    	request.setAttribute("Error", errorbean);
	    }
	 // 次ページへ遷移する
	 		ServletContext sc = getServletContext();
	 		RequestDispatcher rd = sc.getRequestDispatcher(nextPage);
	 		rd.forward(request, response);

	}


	public void init() throws ServletException {
		super.init();
		initCommand();
	}


	private Command lookupCommand(String cmd) throws CommandException {
		if (cmd == null) {
			cmd = "invalid";
		}
		if (commands.containsKey(cmd)) {
			return (Command) commands.get(cmd);
		} else {
			throw new CommandException("不正な画面遷移が行われました。");
		}
	}

	private void initCommand() {
		commands = new HashMap<String,Command>();
		commands.put("LOGIN", new AuthCommand("/menu.jsp"));
		commands.put("LOGOFF", new LogOffCommand("/login.jsp"));
		commands.put("ERROR", new ErrorCommand("/error.jsp"));
		commands.put("RESERVE", new ReserveCommand("/reserve.jsp"));
		commands.put("AVAILABLE", new AvailableResourcesCommand("/availableResources.jsp"));
		commands.put("MENU", new MenuCommand("/menu.jsp"));
		commands.put("CONFIRM", new ConfirmCommand("/confirm.jsp"));
		commands.put("COMPLETE", new CompleteCommand("/complete.jsp"));
		commands.put("REFER", new ReferCommand("/refer.jsp"));
		commands.put("REFERDETAIL",new ReferDetailCommand("/referDetail.jsp"));
		commands.put("CANCEL",new CancelCommand("/cancel.jsp"));
		commands.put("ADDRESOURCE", new AddResourceCommand("/addResource.jsp"));
		commands.put("ADDRESOURCEINPUT", new ResourceInputCommand("/addResourceInput.jsp"));
		commands.put("RESOURCECONFIRM",new ResourceConfirmCommand("/resourceConfirm.jsp"));
		commands.put("RESOURCECOMPLETE",new ResourceCompleteCommand("/resourceComplete.jsp"));
		commands.put("DELETERESOURCE", new DeleteResourceCommand("/deleteResource.jsp"));
		commands.put("DELETEDETAIL", new DeleteDetailCommand("/deleteDetail.jsp"));
		commands.put("DELETECONFIRM", new DeleteConfirmCommand("/deleteConfirm.jsp"));
		commands.put("DELETECOMPLETE", new DeleteCompleteCommand("/deleteComplete.jsp"));
	}


}
