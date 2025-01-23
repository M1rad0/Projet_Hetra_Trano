<%@page import="user.*,caisse.Devise,hetra.back.entities.Paiement,hetra.back.entities.Maison,affichage.*" %>

<%  
    UserEJB u = (UserEJB) session.getValue("u");
    Paiement objet = new Paiement();
    PageInsert pi = new PageInsert(objet, request, u);

    Object[] maisons=Maison.getAll();
    
    Liste[] liste=new Liste[1];
    liste[0]=new Liste("id_maison",new Maison(),"adresse","id_maison");
    pi.getFormu().changerEnChamp(liste);
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
            <input name="bute" type="hidden" id="bute" value="module.jsp?but=hetra/paiement/insert.jsp">
            <input name="classe" type="hidden" id="classe" value="hetra.back.entities.Paiement">
            <input name="nomtable" type="hidden" id="nomtable" value="<%=objet.getNomTable()%>">
        </form>
    </div>
</body>