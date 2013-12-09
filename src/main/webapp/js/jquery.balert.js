/**
 * 警告提示框插件
 */

(function($) {    
	$.fn.balert = function(options) {  
		  var defaults = {        
		    url: '' ,
		    title:'',
		    close:false,
		    id:0,
		    div:'.table'
		  };    
		  var opts = $.extend(defaults, options);  
		  
		  $(this).click(function(){
				opts.id = $(this).attr("data");
				var msghtml = '<div class="alert alert-warning alert-dismissable">';
				msghtml +='<button type="button" class="close" data-dismiss="alert" aria-hidden="true">关闭</button>';
				msghtml +='<strong>警告!</strong> '+opts.title;
				msghtml +='<a href="'+opts.url+opts.id+'">确定</a></div>';
				$(opts.div).before(msghtml);
		  });
			
		};
		
})(jQuery); 