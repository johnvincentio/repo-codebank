package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Catalogs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(7);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
    _jspx_dependants.add("/pages/ViewCart.jsp");
    _jspx_dependants.add("/pages/ViewLogout.jsp");
    _jspx_dependants.add("/pages/ViewHome.jsp");
    _jspx_dependants.add("/pages/Parameters.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_html;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_message_key;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_base;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_errors;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_scope_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_iterate_type_property_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_property_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_value_property;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_filter;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_page;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_forward;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_html = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_message_key = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_base = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_errors = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_scope_name_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_iterate_type_property_name_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_property_name_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_form_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_value_property = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_filter = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_submit = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_link_page = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_link_forward = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_html.release();
    _jspx_tagPool_bean_message_key.release();
    _jspx_tagPool_html_base.release();
    _jspx_tagPool_html_errors.release();
    _jspx_tagPool_bean_define_scope_name_id.release();
    _jspx_tagPool_logic_iterate_type_property_name_id.release();
    _jspx_tagPool_bean_define_property_name_id.release();
    _jspx_tagPool_html_form_action.release();
    _jspx_tagPool_html_hidden_value_property.release();
    _jspx_tagPool_bean_write_property_name_filter.release();
    _jspx_tagPool_html_submit.release();
    _jspx_tagPool_html_link_page.release();
    _jspx_tagPool_html_link_forward.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n\n\n\n\n\n\n\n\n");
      //  html:html
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_html_0 = (org.apache.struts.taglib.html.HtmlTag) _jspx_tagPool_html_html.get(org.apache.struts.taglib.html.HtmlTag.class);
      _jspx_th_html_html_0.setPageContext(_jspx_page_context);
      _jspx_th_html_html_0.setParent(null);
      int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
      if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n<head>\n<title>");
          if (_jspx_meth_bean_message_0(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write("</title>\n");
          if (_jspx_meth_html_base_0(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write("\n</head>\n\n<body bgcolor=\"white\">\n<center>\n<h1>");
          if (_jspx_meth_bean_message_1(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write("</h1>\n");
          if (_jspx_meth_html_errors_0(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write('\n');
          out.write('\n');
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_scope_name_id.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
          _jspx_th_bean_define_0.setId("CatalogNames");
          _jspx_th_bean_define_0.setName( jvapp.Constants.CATALOGNAMES_KEY );
          _jspx_th_bean_define_0.setScope("request");
          int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
          if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_scope_name_id.reuse(_jspx_th_bean_define_0);
          java.lang.Object CatalogNames = null;
          CatalogNames = (java.lang.Object) _jspx_page_context.findAttribute("CatalogNames");
          out.write("\n\n<table>\n\t<tr>\n\t\t<th bgcolor=AAAAAA align=center>\n\t\t\t");
          if (_jspx_meth_bean_message_2(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write("</th>\n\t\t<th bgcolor=AAAAAA align=center>\n\t\t\t");
          if (_jspx_meth_bean_message_3(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write("</th>\n\t</tr>\n\n");
          //  logic:iterate
          org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_type_property_name_id.get(org.apache.struts.taglib.logic.IterateTag.class);
          _jspx_th_logic_iterate_0.setPageContext(_jspx_page_context);
          _jspx_th_logic_iterate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
          _jspx_th_logic_iterate_0.setId("item");
          _jspx_th_logic_iterate_0.setType("jvcommon.JVCatalogName");
          _jspx_th_logic_iterate_0.setName("CatalogNames");
          _jspx_th_logic_iterate_0.setProperty("items");
          int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
          if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            jvcommon.JVCatalogName item = null;
            if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_logic_iterate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_logic_iterate_0.doInitBody();
            }
            item = (jvcommon.JVCatalogName) _jspx_page_context.findAttribute("item");
            do {
              out.write('\n');
              out.write('	');
              //  bean:define
              org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id.get(org.apache.struts.taglib.bean.DefineTag.class);
              _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
              _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
              _jspx_th_bean_define_1.setId("id");
              _jspx_th_bean_define_1.setName("item");
              _jspx_th_bean_define_1.setProperty("catalogid");
              int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
              if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_bean_define_property_name_id.reuse(_jspx_th_bean_define_1);
              java.lang.Object id = null;
              id = (java.lang.Object) _jspx_page_context.findAttribute("id");
              out.write("\n\t<tr>\n\t\t");
              //  html:form
              org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_action.get(org.apache.struts.taglib.html.FormTag.class);
              _jspx_th_html_form_0.setPageContext(_jspx_page_context);
              _jspx_th_html_form_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
              _jspx_th_html_form_0.setAction("/SelectCatalog");
              int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
              if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n\t\t\t");
                  //  html:hidden
                  org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_value_property.get(org.apache.struts.taglib.html.HiddenTag.class);
                  _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
                  _jspx_th_html_hidden_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
                  _jspx_th_html_hidden_0.setProperty("catalogid");
                  _jspx_th_html_hidden_0.setValue( String.valueOf(id) );
                  int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
                  if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  _jspx_tagPool_html_hidden_value_property.reuse(_jspx_th_html_hidden_0);
                  out.write("\n\t\t\t<td>");
                  if (_jspx_meth_bean_write_0(_jspx_th_html_form_0, _jspx_page_context))
                    return;
                  out.write("</td>\n\t\t\t<td>");
                  if (_jspx_meth_html_submit_0(_jspx_th_html_form_0, _jspx_page_context))
                    return;
                  out.write("</td>\t\n\t\t");
                  int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_html_form_action.reuse(_jspx_th_html_form_0);
              out.write("\n\t</tr>\n");
              int evalDoAfterBody = _jspx_th_logic_iterate_0.doAfterBody();
              item = (jvcommon.JVCatalogName) _jspx_page_context.findAttribute("item");
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_logic_iterate_type_property_name_id.reuse(_jspx_th_logic_iterate_0);
          out.write("\n\n</table>\n\n");
          out.write("\n\n\n<hr/>\n");
          if (_jspx_meth_html_link_0(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write('\n');
          out.write('\n');
          out.write('\n');
          out.write("\n\n\n<hr/>\n");
          if (_jspx_meth_html_link_1(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write('\n');
          out.write('\n');
          out.write('\n');
          out.write("\n\n\n<hr/>\n");
          if (_jspx_meth_html_link_2(_jspx_th_html_html_0, _jspx_page_context))
            return;
          out.write('\n');
          out.write('\n');
          out.write('\n');
          out.write('\n');
          out.write("\n\n\n\n\n<HR>\n<H1> Parameters </H1>\n<TABLE>\n<TR><TD BGCOLOR=AAAAAA ALIGN=CENTER>Parameter Name</TD>\n    <TD BGCOLOR=AAAAAA>Parameter Value</TD>\n</TR>\n\n");
 Enumeration itr1 = request.getParameterNames();
	while (itr1.hasMoreElements()) {
		String pName = (String) itr1.nextElement();
		String pValue = request.getParameter(pName); 
          out.write("\n\t\t<TR><TD BGCOLOR=DDDDDD>");
          out.print(pName);
          out.write("</TD>\n\t\t<TD BGCOLOR=DDDDDD>");
          out.print(pValue);
          out.write("</TD>\n\t\t</TR>\n");
 } 
          out.write("\t\t\n</TABLE>\n\n<HR>\n\n<H1> Attributes </H1>\n<TABLE>\n<TR><TD BGCOLOR=AAAAAA ALIGN=CENTER>Attribute Name</TD>\n</TR>\n\n");
 Enumeration itr2 = request.getAttributeNames();
	while (itr2.hasMoreElements()) {
		String pName = (String) itr2.nextElement(); 
          out.write("\n\t\t<TR><TD BGCOLOR=DDDDDD>");
          out.print(pName);
          out.write("</TD>\n\t\t</TR>\n");
 } 
          out.write("\t\t\n</TABLE>\n\n<HR>\n\n");
          out.write("\n\n</center>\n</body>\n");
          int evalDoAfterBody = _jspx_th_html_html_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_html.reuse(_jspx_th_html_html_0);
      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_bean_message_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_0 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_bean_message_0.setKey("catalogs.title");
    int _jspx_eval_bean_message_0 = _jspx_th_bean_message_0.doStartTag();
    if (_jspx_th_bean_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_0);
    return false;
  }

  private boolean _jspx_meth_html_base_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:base
    org.apache.struts.taglib.html.BaseTag _jspx_th_html_base_0 = (org.apache.struts.taglib.html.BaseTag) _jspx_tagPool_html_base.get(org.apache.struts.taglib.html.BaseTag.class);
    _jspx_th_html_base_0.setPageContext(_jspx_page_context);
    _jspx_th_html_base_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    int _jspx_eval_html_base_0 = _jspx_th_html_base_0.doStartTag();
    if (_jspx_th_html_base_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_base.reuse(_jspx_th_html_base_0);
    return false;
  }

  private boolean _jspx_meth_bean_message_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_1 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_bean_message_1.setKey("catalogs.header");
    int _jspx_eval_bean_message_1 = _jspx_th_bean_message_1.doStartTag();
    if (_jspx_th_bean_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_1);
    return false;
  }

  private boolean _jspx_meth_html_errors_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:errors
    org.apache.struts.taglib.html.ErrorsTag _jspx_th_html_errors_0 = (org.apache.struts.taglib.html.ErrorsTag) _jspx_tagPool_html_errors.get(org.apache.struts.taglib.html.ErrorsTag.class);
    _jspx_th_html_errors_0.setPageContext(_jspx_page_context);
    _jspx_th_html_errors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    int _jspx_eval_html_errors_0 = _jspx_th_html_errors_0.doStartTag();
    if (_jspx_th_html_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_errors.reuse(_jspx_th_html_errors_0);
    return false;
  }

  private boolean _jspx_meth_bean_message_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_2 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_bean_message_2.setKey("catalogs.catalog");
    int _jspx_eval_bean_message_2 = _jspx_th_bean_message_2.doStartTag();
    if (_jspx_th_bean_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_2);
    return false;
  }

  private boolean _jspx_meth_bean_message_3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_3 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_bean_message_3.setKey("catalogs.option");
    int _jspx_eval_bean_message_3 = _jspx_th_bean_message_3.doStartTag();
    if (_jspx_th_bean_message_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_3);
    return false;
  }

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_filter.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_bean_write_0.setName("item");
    _jspx_th_bean_write_0.setProperty("ds");
    _jspx_th_bean_write_0.setFilter(false);
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_filter.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_submit_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_submit_0.doInitBody();
      }
      do {
        out.write("\n\t\t\t\t");
        if (_jspx_meth_bean_message_4(_jspx_th_html_submit_0, _jspx_page_context))
          return true;
        out.write("\n\t\t\t");
        int evalDoAfterBody = _jspx_th_html_submit_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_submit.reuse(_jspx_th_html_submit_0);
    return false;
  }

  private boolean _jspx_meth_bean_message_4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_submit_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_4 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_4.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_submit_0);
    _jspx_th_bean_message_4.setKey("catalogs.submit");
    int _jspx_eval_bean_message_4 = _jspx_th_bean_message_4.doStartTag();
    if (_jspx_th_bean_message_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_4);
    return false;
  }

  private boolean _jspx_meth_html_link_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_0 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_link_0.setPageContext(_jspx_page_context);
    _jspx_th_html_link_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_html_link_0.setPage("/Cart.do");
    int _jspx_eval_html_link_0 = _jspx_th_html_link_0.doStartTag();
    if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_link_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_link_0.doInitBody();
      }
      do {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_bean_message_5(_jspx_th_html_link_0, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_html_link_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_link_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_0);
    return false;
  }

  private boolean _jspx_meth_bean_message_5(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_5 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_5.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_0);
    _jspx_th_bean_message_5.setKey("viewcart.submit");
    int _jspx_eval_bean_message_5 = _jspx_th_bean_message_5.doStartTag();
    if (_jspx_th_bean_message_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_5);
    return false;
  }

  private boolean _jspx_meth_html_link_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_1 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_forward.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_link_1.setPageContext(_jspx_page_context);
    _jspx_th_html_link_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_html_link_1.setForward("logoff");
    int _jspx_eval_html_link_1 = _jspx_th_html_link_1.doStartTag();
    if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_link_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_link_1.doInitBody();
      }
      do {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_bean_message_6(_jspx_th_html_link_1, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_html_link_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_link_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_link_forward.reuse(_jspx_th_html_link_1);
    return false;
  }

  private boolean _jspx_meth_bean_message_6(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_1, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_6 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_6.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_1);
    _jspx_th_bean_message_6.setKey("viewlogout.logoff");
    int _jspx_eval_bean_message_6 = _jspx_th_bean_message_6.doStartTag();
    if (_jspx_th_bean_message_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_6);
    return false;
  }

  private boolean _jspx_meth_html_link_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_2 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_link_2.setPageContext(_jspx_page_context);
    _jspx_th_html_link_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_html_link_2.setPage("/Home.do");
    int _jspx_eval_html_link_2 = _jspx_th_html_link_2.doStartTag();
    if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_link_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_link_2.doInitBody();
      }
      do {
        out.write('\n');
        out.write('	');
        if (_jspx_meth_bean_message_7(_jspx_th_html_link_2, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_html_link_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_link_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_2);
    return false;
  }

  private boolean _jspx_meth_bean_message_7(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_2, PageContext _jspx_page_context)
          throws Throwable {
    JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_message_7 = (org.apache.struts.taglib.bean.MessageTag) _jspx_tagPool_bean_message_key.get(org.apache.struts.taglib.bean.MessageTag.class);
    _jspx_th_bean_message_7.setPageContext(_jspx_page_context);
    _jspx_th_bean_message_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_2);
    _jspx_th_bean_message_7.setKey("viewhome.submit");
    int _jspx_eval_bean_message_7 = _jspx_th_bean_message_7.doStartTag();
    if (_jspx_th_bean_message_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_message_key.reuse(_jspx_th_bean_message_7);
    return false;
  }
}
