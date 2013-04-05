<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<!-- page分页 -->
	<div class="pagination">
		  <ul>
		    <c:if test="${page.index  == 1}">
		    <li><a a href="javascript:void(0);" onclick="GoFormIndex(${page.index-1});"><</a></li>
		    </c:if>
		    <#list 1..page.size as xx>
		    <li <c:if test="xx == page.index" > class="active"</c:if>><a href="javascript:void(0);" onclick="GoFormIndex(${xx});">${xx}</a></li>
			</#list> 
		    <c:if test="${page.size  > page.index}">
		    <li><a a href="javascript:void(0);" onclick="GoFormIndex(${page.index +1 });">></a></li>
		    </c:if>
		  </ul> 
		</div>
		<script type="text/javascript" >
		function GoFormIndex(pi){
			document.getElementById("formindex").value = pi;
		    document.formsearch.submit();
		}
		</script>
