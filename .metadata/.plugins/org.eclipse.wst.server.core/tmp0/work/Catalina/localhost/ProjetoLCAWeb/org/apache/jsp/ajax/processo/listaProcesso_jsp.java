/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.33
 * Generated at: 2013-10-10 00:24:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ajax.processo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jpro.lca.util.ConversaoUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jpro.lca.bo.AdvocaciaNegocio;
import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.bean.Processo;
import java.util.List;

public final class listaProcesso_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


List<Processo> processos = AdvocaciaNegocio.ListarProcessos();

if(processos.size() > 0){
	for (Processo p: processos){
		out.println(
				"<div class=\"formsearch-box\"><a href=\"atualizaProcesso?idPro="+p.getNr_processo()+"#\" id=\"janela\">"+
			    ConversaoUtil.ExibirData(p.getDt_abertura(), "dd/MM/yyyy")+" - "+
			    p.getDs_processo()+
				"</a><p>"+
				p.getDs_processo()+
				"<a href=\"ajax/processo/excluirProcesso.jsp?id="+p.getNr_processo()+"\"><img src=\"images/delete.png\" id=\"delete\" /></a></p></div>"
				);
	}
}else{
	out.println("Nenhum processo encontrado!");
}




//out.println();

/*
dt_abertura

cd_resultado

forum

cliente


tipoCausa

*/




    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
