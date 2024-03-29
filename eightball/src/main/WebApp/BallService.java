import java.util.Random;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    List<String> ImaginaryRedisDB = new List<String>();
    List<String> options = new List<String>();
    options.add("It is certain.");
    options.add("It is decidedly so.");
    options.add("Without a doubt.");
    options.add("Yes - definitely.");
    options.add("You may rely on it.");
    options.add("You may rely on it.");
    options.add("Most likely.");
    options.add("Outlook good.");
    options.add("Yes.");
    options.add("Signs point to yes");
    options.add("Reply hazy, try again.");
    options.add("Ask again later.");
    options.add("Better not tell you now.");
    options.add("Cannot predict now.");
    options.add("Concentrate and ask again.");
    options.add("Don't count on it.");
    options.add("My reply is no.");
    options.add("My sources say no.");
    options.add("Outlook not so good.");
    options.add("Very doubtful.");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("btnRoll") != null) {
            Random r = new Random();
            int roll;
            if (ImaginaryRedisDB.Contains(request.getParameter("btnRoll"))) {
                String message;
                for (string record: ImaginaryRedisDB) {
                    if (record.Contains(request.getParameter("btnRoll"))){
                        message = record.Split(';')[1];
                    }
                }
                request.setAttribute("message", message)
            } else if (options.count > 0) {
                roll = Random.nextInt(options.count);
                request.setAttribute("message",options[roll]);
                ImaginaryRedisDB.add(String.concat(request.getParameter("btnRoll"), "; ", options[roll]));
                options.remove(roll);
            } else {
                roll = Random.nextInt(ImaginaryRedisDB.count);
                request.setAttribute("message", ImaginaryRedisDB[roll].Split(';')[1]);
            }
        }
        request.getRequestDispatcher("/WebApp/result.jsp").forward(request, response);
    }

}