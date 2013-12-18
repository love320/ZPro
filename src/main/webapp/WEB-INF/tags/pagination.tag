<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.love320.zpro.code.bean.Page" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		  <div><ul class="pagination">
		    <c:if test="${page.index  != 1}">
		    <li><a a href="javascript:void(0);" onclick="GoFormIndex(${page.index-1});"><</a></li>
		    </c:if>
		    <c:forEach var="xx" begin="1" end="${page.size}" step="1">
		    <li <c:if test="${xx == page.index}" > class="active"</c:if>><a href="javascript:void(0);" onclick="GoFormIndex(${xx});">${xx}</a></li>
			</c:forEach>
		    <c:if test="${page.size  > page.index}">
		    <li><a a href="javascript:void(0);" onclick="GoFormIndex(${page.index +1 });">></a></li>
		    </c:if>
		  </ul></div>
		<script type="text/javascript" >
		function GoFormIndex(pi){
			document.getElementById("formindex").value = pi;
		    document.formsearch.submit();
		}
		</script>

