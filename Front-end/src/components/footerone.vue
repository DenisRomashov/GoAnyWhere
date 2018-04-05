<template lang="html">
  <div class="content">
     <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
      <footer id="myFooter">
          <div class="container">
              <div class="row">
                  <div class="col-sm-3">
                      <h2 class="logo"><a href="#"> GAW </a></h2>
                      <h3>GoAnyWhere</h3>
                      <p>Click & meet</p>
                  </div>
                  <div class="col-sm-2">
                      <h5>Get started</h5>
                      <ul>
                          <li><a href="#">Home</a></li>
                          <li><a href="#">Sign up</a></li>
                          <li><a href="#">Downloads</a></li>
                      </ul>
                  </div>
                  <div class="col-sm-2">
                      <h5>About us</h5>
                      <ul>
                          <li><a href="#">Company Information</a></li>
                          <li><a href="#">Contact us</a></li>
                          <li><a href="#">Reviews</a></li>
                      </ul>
                  </div>
                  <div class="col-sm-2">
                      <h5>Support</h5>
                      <ul>
                          <li><a href="#">FAQ</a></li>
                          <li><a href="#">Help desk</a></li>
                          <li><a href="#">Forums</a></li>
                      </ul>
                  </div>
                  <div class="col-sm-3">
                      <div class="social-networks">
                          <a href="#" class="instagram"><i class="fa fa-instagram"></i></a>
                          <a href="https://github.com" target="_blank" class="github"><i class="fa fa-github"></i></a>
                          <a href="#" class="vk"><i class="fa fa-vk"></i></a>
                      </div>
                      <button type="button" class="btn btn-default">Связаться</button>
                  </div>
              </div>
          </div>
          <div class="footer-copyright">
              <p>© GoAnyWhere Project 2018
                <a href="https://github.com" target="_blank" class="github"><i class="fa fa-github"></i></a>
              </p>
          </div>
      </footer>
    </div>
</template>

<script>
export default {
}
</script>

<style lang="css">
#myFooter {
    background-color: #3c3d41;
    color: white;
    padding-top: 30px;
}

#myFooter .footer-copyright {
    background-color: #333333;
    padding-top: 3px;
    padding-bottom: 3px;
    text-align: center;
}

#myFooter .row {
    margin-bottom: 60px;
}

#myFooter .navbar-brand {
    margin-top: 45px;
    height: 65px;
}

#myFooter .footer-copyright p {
    margin: 10px;
    color: #ccc;
}

#myFooter ul {
    list-style-type: none;
    padding-left: 0;
    line-height: 1.7;
}

#myFooter h5 {
    font-size: 18px;
    color: white;
    font-weight: bold;
    margin-top: 30px;
}

#myFooter h2 a{
    font-size: 50px;
    text-align: center;
    color: #fff;
}

#myFooter a {
    color: #d2d1d1;
    text-decoration: none;
}

#myFooter a:hover,
#myFooter a:focus {
    text-decoration: none;
    color: white;
}

#myFooter .social-networks {
    text-align: center;
    padding-top: 30px;
    padding-bottom: 16px;
}

#myFooter .social-networks a {
    font-size: 32px;
    color: #f9f9f9;
    padding: 10px;
    transition: 0.2s;
}

#myFooter .social-networks a:hover {
    text-decoration: none;
}

#myFooter .github:hover {
    color: #696969;
}

#myFooter .instagram:hover {
    color: #FFD700;
}

#myFooter .vk:hover {
    color: #6495ED;
}

#myFooter .btn {
    color: white;
    background-color: #d84b6b;
    border-radius: 20px;
    border: none;
    width: 150px;
    display: block;
    margin: 0 auto;
    margin-top: 10px;
    line-height: 25px;
}

@media screen and (max-width: 767px) {
    #myFooter {
        text-align: center;
    }
}

/* CSS used for positioning the footers at the bottom of the page. */
/* You can remove this. */

html{
    height: 100%;
}

body{
    display: flex;
    display: -webkit-flex;
    flex-direction: column;
    -webkit-flex-direction: column;
    height: 100%;
}

.content{
   flex: 1 0 auto;
   -webkit-flex: 1 0 auto;
   min-height: 200px;
}

#myFooter{
   flex: 0 0 auto;
   -webkit-flex: 0 0 auto;
}
</style>
