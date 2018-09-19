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
public class ControllerServlet extends HttpServlet {



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
	    request.setCharacterEncoding("UTF-8");

	    try {
	    	String commandKey = request.getParameter("COMMAND");
			Command command = lookupCommand(commandKey);

		    nextPage = command.execute(request,response);


	    }
	    catch(CommandException | SQLException e) {
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
		commands.put("AVAILABLERESOURCES", new AvailableResourcesCommand("/availableResource.jsp"));
		commands.put("AVAILABLERESOURCE", new ReserveCommand("/reserve.jsp"));
		commands.put("RESERVE", new ConfirmCommand("/confirm.jsp"));
		commands.put("CONFIRM", new CompleteCommand("/complete.jsp"));
		commands.put("MENU", new MenuCommand("/menu.jsp"));
		}


}
