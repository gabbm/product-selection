<%@include file="common/header.jsp" %>

	<c:url var="checkoutUrl" value='/checkout' />

    <!-- Begin page content -->
    <div class="container">
      	<div class="row match-cols">
        	<div id="sport-row" class="col-lg-3 jumbotron">
        		<h2>Sports</h2>
	        	<div id="sport-row-container"></div>
        		<br/>
        	</div>
      		<div id="news-row" class="col-lg-3 col-md-offset-1 jumbotron">
      			<h2>News</h2>
        		<div id="news-row-container"></div>
        		<br/>
        	</div>
        	<div class="col-lg-4 col-md-offset-1 jumbotron">
        		<h2>Basket</h2>
        		
        		<form:form modelAttribute="checkoutForm" action="${checkoutUrl}" method="post" role="form">
		       		<form:input type="hidden" path="customerId" name="customerId" id="customerId" value=""/>
		       		<div>
		       			<ul id="basket-detail"></ul>
		       		</div>
		       		<div class="btn-checkout">
		       			<button type="submit" class="btn btn-primary">Checkout</button>
		       		</div>
        		</form:form>
        	</div>
        </div>
    </div>


<script type="text/javascript">
	var userApi = "/api/products/user/";

	$(document).ready(function(){
		
		// -- TESTING --
		// Set customerId to 1 for testing purposes
		$.cookie.set('customerId', 1);
		// -- END TESTING --
		
		$('#customerId').val($.cookie.get('customerId'));
		productsAjax();
	});
	
	$(document).on('click', '.sport-product-element', function(event){
		productCheck($(this).find("input"), $(this).find("span"));
	});
	
	$(document).on('click', '.news-product-element', function(event){
		productCheck($(this).find("input"), $(this).find("span"));
	});
	
	function changeCookieIdAndRefreshAjax(id){
		$.cookie.set('customerId', id);
		$('#customerId').val($.cookie.get('customerId'));
		productsAjax();
	}
	
	function productsAjax(){
		$('#sport-row-container').empty();
		$('#news-row-container').empty();
		
		$.ajax({
			url: userApi + $.cookie.get('customerId')
		}).then(function(data){
			$.each(data, function(i, item){
				if(item.type == "SPORT"){
					$('#sport-row-container').append('<div class="row sport-product-element"><input type="checkbox" name="sport_' + item.id + '" id="' + item.id + '" value="' + item.id + '"/> <span>' + item.name + '</span></div>');
				}else if(item.type == "NEWS"){
					$('#news-row-container').append('<div class="row news-product-element"><input type="checkbox" name="news_' + item.id + '" id="' + item.id + '" value="' + item.id + '"/> <span>' + item.name + '</span></div>');
				}
			});
		});
	}
	
	function productCheck(selectedProduct, title){
		if(selectedProduct != undefined){
			if(selectedProduct.is(':checked')){
				addProduct2Basket(title.text(), selectedProduct.attr('id'));
			}else{
				removeProductFromBasket(selectedProduct.attr('id'));
			}
		}
	}
	
	function addProduct2Basket(title, id){
		$('#basket-detail').append('<li id="basket-product-' + id + '"><span>' + title + '</span><input type="hidden" name="products" value="' + id + '"/></li>');
	}
	
	function removeProductFromBasket(id){
		$('#basket-product-' + id).remove();
	}
</script>

<%@include file="common/footer.jsp" %>