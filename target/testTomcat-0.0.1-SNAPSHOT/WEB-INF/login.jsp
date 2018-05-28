<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>

<form action="login.do">
			<div class="modal-content">

				<div class="modal-header">

					<h5 class="modal-title" id="exampleModalLabel">Connexion</h5>

				</div>

				<div class="modal-body">

					<form>

						<div class="form-group">

							<div class="input-group">

								<div class="input-group-prepend">

									<div class="input-group-text">
										<i class="fas fa-user"></i>
									</div>

								</div>

								<input type="text" class="form-control" name="email" id=""
									placeholder="Adresse mail | Pseudo" class="input_modal">

							</div>

						</div>

						<div class="form-group">

							<div class="input-group">

								<div class="input-group-prepend">

									<div class="input-group-text">
										<i class="fas fa-lock"></i>
									</div>

								</div>

								<input type="text" class="form-control" name="password" id=""
									placeholder="Mot de passe" class="input_modal">

							</div>

						</div>

					</form>

					<hr class="hr-text" data-content="OU">

					<div class="justify-content-center" id="delete_it_later_block_img">

						<img src="img/connexion-RS.png">

					</div>

				</div>

				<div class="modal-footer justify-content-center">

					<a href="home_user.php" style="width: 100%;">

						<button type="submit" class="btn button_submit_modal"
							id="button_submit_connexion_modal">Connexion !</button>

					</a>

				</div>

			</div>
</form>

</body>
</html>