/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.VyMajoris.unitedOperations.ratioCalculator;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RatioCalculator extends HttpServlet {


    double total = 0;
    double bluforR = 0;
    double redforR = 0;
    double indyR = 0;
    double civR = 0;


    double bluforP;
    double redforP;
    double indyP;
    double civP;



    float bluforPerc;
    float redforPerc;
    float indyPerc;
    float civPerc;

    double leftOver = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        //nothing
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/plain");
        HttpSession session = request.getSession(true);


        String bluforS = request.getParameter("blufor");
        String redforS = request.getParameter("redfor");
        String indyS = request.getParameter("indy");
        String civS = request.getParameter("civ");
        String totalS = request.getParameter("total");






        if (!bluforS.equals("")) {
            bluforR = Double.parseDouble(bluforS);
            session.setAttribute("bluforR", bluforR);
        }else{
            bluforR = 0;
        }
        if (!redforS.equals("")) {
            redforR = Double.parseDouble(redforS);
            session.setAttribute("redforR", redforR);
        }else{
            redforR = 0;
        }
        if (!indyS.equals("")) {
            indyR = Double.parseDouble(indyS);
            session.setAttribute("indyR", indyR);
        }else{
            indyR = 0;
        }
        if (!civS.equals("")) {
            civR = Double.parseDouble(civS);
            session.setAttribute("civR", civR);
        }else{
            civR = 0;
        }

        if (!totalS.equals("")) {
            total = Double.parseDouble(totalS);
            session.setAttribute("total",(int) total);
            session.setAttribute("bluforP", (int) bluforP);
            session.setAttribute("redforP", (int)redforP);
            session.setAttribute("indyP", (int) indyP);
            session.setAttribute("civP", (int) civP);

            session.setAttribute("bluforPerc", bluforPerc);
            session.setAttribute("redforPerc", redforPerc);
            session.setAttribute("indyPerc", indyPerc);
            session.setAttribute("civPerc", civPerc);

            if (leftOver != 0 ) {
                session.setAttribute("spill", "Total left over: "+ leftOver);
            }else{
                session.setAttribute("spill", null);
            }


        }else{

        }


        calculate(bluforR, redforR, indyR, civR, total);


        response.sendRedirect(request.getHeader("Referer"));

    }



    private void calculate(double bluforR, double redforR, double indyR, double civR, double total) {

        //p = players
        //r = ratio inserted
        //perc = percentage

        double totalRatio = bluforR + civR + indyR + redforR;
        //(int) Math.Round(Math.Floor((double) ((((double) (this.numPlayers - this.extraNumber)) / num) * this.bluforRatio)));
        bluforP = Math.floor((total / totalRatio) * bluforR);
        redforP = Math.floor((total / totalRatio) * redforR);
        indyP = Math.floor((total / totalRatio) * indyR);
        civP = Math.floor((total / totalRatio) * civR);

        bluforPerc = (float) Math.ceil((bluforP * 100) / total);
        redforPerc = (float) Math.ceil((redforP*100)/total);
        indyPerc = (float) Math.ceil((indyP*100)/total);
        civPerc = (float) Math.ceil((civP*100)/total);

        float totalPerc = bluforPerc+civPerc+redforPerc+indyPerc;
        float totalPercWork =  100 - totalPerc;


        int teamsCount = 0;
            if (bluforPerc != 0) {
                teamsCount++;

            }
            if (redforPerc != 0) {
                teamsCount++;
            }
            if (indyPerc != 0) {
                teamsCount++;
            }
            if (civPerc != 0) {
                teamsCount++;
            }


            totalPercWork = totalPercWork / teamsCount;
            if (bluforPerc != 0) {

                bluforPerc = bluforPerc + totalPercWork;
            }
            if (redforPerc != 0) {

                redforPerc = redforPerc + totalPercWork;
            }
            if (indyPerc != 0) {

                indyPerc = indyPerc + totalPercWork;
            }
            if (civPerc != 0) {

                civPerc = civPerc + totalPercWork;
            }






        System.out.println("______________________");
        System.out.println("BLUFOR = " + bluforP);
        System.out.println("REDFOR = " + redforP);
        System.out.println("INDY = " + indyP);
        System.out.println("CIV = " + civP);
        System.out.println("BLUFOR-PERC = " + bluforPerc);
        System.out.println("REDFOR-PERC = " + redforPerc);
        System.out.println("INDY-PERC = " + indyPerc);
        System.out.println("CIV-PERC = " + civPerc);
        System.out.println("TOTAL-PERC = " + totalPerc);

        System.out.println("*******************");
        System.out.println("TOTAL PLAYERS RESULT = " + (bluforP + redforP + civP + indyP));
        // System.out.println("TOTAL RATIO RESULT = " + totalRatio);
        System.out.println("TOTAL SPILL = " + (total - (bluforP + redforP + civP + indyP)));


        leftOver = total - (bluforP + redforP + civP + indyP);


        System.out.println("*******************");


    }
}
