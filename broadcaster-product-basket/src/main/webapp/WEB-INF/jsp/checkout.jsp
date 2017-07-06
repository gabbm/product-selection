<%@include file="common/header.jsp" %>

<div class="container jumbotron">
	<h2>Hi ${basket.customer.name}!</h2>
	
	<div>
		<p>
			Your order id is ${basket.orderId}:
		</p>
		<ul>
			<c:forEach var="product" items="${basket.products}">
				<li>${product.name}</li>
			</c:forEach>
		</ul>
		<div class="btn-checkout">
			<a href="/" class="btn btn-primary">< Back </a>
		</div>
	</div>
</div>

<%@include file="common/footer.jsp" %>