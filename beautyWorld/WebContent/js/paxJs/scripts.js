$(document).ready(function() {
	$("#category li").hide();
	
    $('.header_menu li').hover(
        function () {
        	$("#category li").show();
        }, 
        function () {
        	$("#category li").hide();         
        }
    );

/*	$('ul:first', this).css('display','none');     
	
	$('.header_menu li').hover(
	        function () {
	            $('ul:first', this).css('display','block');
	        }, 
	        function () {
	            $('ul:first', this).css('display','none');         
	        }
	    ); */ 
    
    
	
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	    
	$('#main_header_menu').slicknav();
	    
	if($('#header').css('position') == 'absolute')
		$('#header').css('top', $('.slicknav_menu').outerHeight() + 'px');
	else
		$('#header').css('top', '0px');                 				    
    // function not used. 
    function onComplete(data) {
    }    
/*
    $('.stalac_box').hover(
    	function() {
    		$(this).find('.stalac_box_hover').css('display','block');
    	},
    	function() {
    		$(this).find('.stalac_box_hover').css('display','none');
    	}
    );
  */
	$("#home_cont").on("mouseenter", "#stalac_cont .stalac_box", function(event){
		$(this).find('.stalac_box_hover').css('display','block');
	}).on("mouseleave", "#stalac_cont .stalac_box", function(event){
		$(this).find('.stalac_box_hover').css('display','none');
	});  
    //#stalac_cont
/*
	$("#stalac_cont").stalactite({
		duration: 350,                        // Duration of animation.
		easing: 'swing',                      // Easing method.
		cssPrefix: '.stalactite',             // The css naming convention.
		cssPrep: true,                        // Should stalactite structurally modify css of children?
		fluid: true,                          // Should stalactite recalculate on window resize?
//		loader: '<img />',                    // The contents of the loader. Defaults to a dataURL animated gif.
		styles: {},                            // A style object to place on the child elements
		complete: function(v) { return v; }  // Callback function
	});    
*/
	/*$('#stalac_cont').stalactite();*/
	    
	$('.archive_box_media').hover(
		function() {
			$(this).find('.archive_box_hover').css('display','block');
		},
		function() {
			$(this).find('.archive_box_hover').css('display','none');
		}
	);
	    
	    
});
$(window).load(function() {
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	if(!$('.header_menu').is(':visible'))
		$('#header').css('top',$('.slicknav_menu').outerHeight() + 'px');
	else
		$('#header').css('top','0px');
});
$(window).scroll(function() {
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	
});
$(window).resize(function() {
	if(!$('.header_menu').is(':visible'))
		$('#header').css('top',$('.slicknav_menu').outerHeight() + 'px');	
	else
		$('#header').css('top','0px');	
});