<%@page import="user.*,hetra.back.entities.Maison,affichage.*" %>

<%  
    UserEJB u = (UserEJB) session.getValue("u");
    Maison  objet = new Maison();
    //objet.setNomTable(nomtable);
    PageInsert pi = new PageInsert(objet, request, u);
    //pi.getFormu().changerEnChamp(liste);
    pi.preparerDataFormu();
%>

<html>
<body>
    <div class="content-wrapper">
        <form action="apresTarif.jsp" method="get">
            <%
                pi.getFormu().makeHtmlInsertTabIndex();
                out.println(pi.getFormu().getHtmlInsert());
            %>

            <input name="acte" type="hidden" id="nature" value="insert">
            <input name="bute" type="hidden" id="bute" value="module.jsp?but=hetra/maison/insert.jsp">
            <input name="classe" type="hidden" id="classe" value="hetra.back.entities.Maison">
            <input name="nomtable" type="hidden" id="nomtable" value="<%=objet.getNomTable()%>">
        </form>
    </div>
</body>