webpackJsonp([0],{"1/oy":function(t,a){},"9M+g":function(t,a){},ELQy:function(t,a){},Id91:function(t,a){},Jmt5:function(t,a){},KYdT:function(t,a){},NHnr:function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var s=e("7+uW"),r={render:function(){var t=this.$createElement,a=this._self._c||t;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},staticRenderFns:[]};var n=e("VU/8")({name:"App"},r,!1,function(t){e("gsu9")},null,null).exports,i=e("/ocq"),o=e("mvHQ"),l=e.n(o),m={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-carousel",{staticStyle:{"text-shadow":"1px 1px 2px #333"},attrs:{id:"carousel1",controls:"",indicators:"",background:"#ababab",interval:4e3,"img-width":"1024","img-height":"480"},on:{"sliding-start":t.onSlideStart,"sliding-end":t.onSlideEnd},model:{value:t.slide,callback:function(a){t.slide=a},expression:"slide"}},[e("b-carousel-slide",{staticClass:"slide1",attrs:{caption:"GoAnyWhere - Click & Meet",text:"Найди то, что тебе по душе!","img-blank":"","img-alt":"Blank image"}},[e("router-link",{attrs:{to:{path:"registration"}}},[e("b-button",{attrs:{size:"",variant:"danger"}},[t._v("Регистрация")])],1)],1),t._v(" "),e("b-carousel-slide",{staticClass:"slide2",attrs:{"img-blank":"","img-alt":"Blank image"}},[e("h1",[t._v("GoAnyWhere Project 2018 ©")]),t._v(" "),e("h3",[t._v("Делай, учись, делись, меняй (do, learn, share, change)")])]),t._v(" "),e("b-carousel-slide",{staticClass:"slide3",attrs:{"img-blank":"","img-alt":"Blank image"}}),t._v(" "),e("b-carousel-slide",{staticClass:"slide4",attrs:{caption:"Делай что-нибудь","img-blank":"","img-alt":"Blank image"}},[e("p",[t._v("\n        Это значит, что нельзя сидеть на месте и ждать, пока другой реализует интересную идею,\n        родившуюся у тебя в голове. Какой бы сумасбродной ни была мысль – делись ею, ищи единомышленников,\n        думайте как реализовать ее, встречайтесь, организовывайте.\n        Самое главное – это понять, что ты не одинок и в любом случае найдутся люди, готовые тебя поддержать.\n      ")])])],1)],1)},staticRenderFns:[]};var v=e("VU/8")({data:function(){return{slide:0,sliding:null}},methods:{onSlideStart:function(t){this.sliding=!0},onSlideEnd:function(t){this.sliding=!1}}},m,!1,function(t){e("epkc")},null,null).exports,u={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"content"},[e("link",{attrs:{rel:"stylesheet",href:"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"}}),t._v(" "),e("footer",{attrs:{id:"myFooter"}},[e("div",{staticClass:"container"},[e("div",{staticClass:"row"},[e("div",{staticClass:"col-sm-3"},[e("h2",{staticClass:"logo"},[e("a",{attrs:{href:"/"}},[t._v(" GAW ")])]),t._v(" "),e("h3",[t._v("GoAnyWhere")]),t._v(" "),e("p",[t._v("Click & meet")])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("Get started")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("Главная")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Зарегистрироваться")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Войти")])])])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("About us")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("Информация о нас")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Контакты")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Reviews")])])])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("Support")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("FAQ")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Help desk")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Forums")])])])]),t._v(" "),e("div",{staticClass:"col-sm-3"},[e("div",{staticClass:"social-networks"},[e("a",{staticClass:"instagram",attrs:{href:"#"}},[e("i",{staticClass:"fa fa-instagram"})]),t._v(" "),e("a",{staticClass:"github",attrs:{href:"https://github.com",target:"_blank"}},[e("i",{staticClass:"fa fa-github"})]),t._v(" "),e("a",{staticClass:"vk",attrs:{href:"#"}},[e("i",{staticClass:"fa fa-vk"})])]),t._v(" "),e("button",{staticClass:"btn btn-default",attrs:{type:"button"}},[t._v("Связаться")])])])]),t._v(" "),e("div",{staticClass:"footer-copyright"},[e("p",[t._v("© GoAnyWhere Project 2018\n              "),e("a",{staticClass:"github",attrs:{href:"https://github.com",target:"_blank"}},[e("i",{staticClass:"fa fa-github"})])])])])])}]};var c=e("VU/8")({},u,!1,function(t){e("KYdT")},null,null).exports,p={data:function(){return{form:{username:"",password:""},show:!0}},methods:{onSubmit:function(t){t.preventDefault(),alert(l()(this.form))}},components:{Carousel:v,footerone:c}},f={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-button",{attrs:{size:"",variant:"outline-danger"}},[t._v("О нас")]),t._v(" "),e("b-navbar-nav",{staticClass:"ml-auto"},[e("div",[t.show?e("b-form",{attrs:{inline:""},on:{submit:t.onSubmit}},[e("label",{staticClass:"sr-only",attrs:{for:"inlineInputUsername"}},[t._v("Username")]),t._v(" "),e("b-input",{staticClass:"xs-2 mr-sm-2 mb-sm-0",attrs:{id:"inlineInputUsername",type:"text",placeholder:"Username"},model:{value:t.form.username,callback:function(a){t.$set(t.form,"username","string"==typeof a?a.trim():a)},expression:"form.username"}}),t._v(" "),e("label",{staticClass:"sr-only",attrs:{for:"inlineInputPassword"}},[t._v("Password")]),t._v(" "),e("b-input-group",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{left:"@"}},[e("b-input",{attrs:{id:"inlineInputPassword",type:"password",placeholder:"Password"},model:{value:t.form.password,callback:function(a){t.$set(t.form,"password",a)},expression:"form.password"}})],1),t._v(" "),e("b-button",{attrs:{size:"",type:"submit",variant:"outline-primary"}},[t._v("Войти")]),t._v(" "),e("router-link",{attrs:{to:{path:"registration"}}},[e("b-button",{attrs:{size:"",variant:"outline-danger"}},[t._v("Регистрация")])],1)],1):t._e()],1)])],1),t._v(" "),e("carousel"),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var d=e("VU/8")(p,f,!1,function(t){e("ELQy")},null,null).exports,_={data:function(){return{form:{username:"",password:"",repassword:"",email:"",firstname:"",lastname:""},sex:[{text:"Выбирите пол"},"male","female"],show:!0}},methods:{onSubmit:function(t){t.preventDefault(),alert(l()(this.form)),console.log(l()(this.form))},onReset:function(t){var a=this;t.preventDefault(),this.form.username="",this.form.password="",this.form.repassword="",this.form.email="",this.form.firstname="",this.form.lastname="",this.form.sex=null,this.show=!1,this.$nextTick(function(){a.show=!0})}},components:{footerone:c}},b={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-container",{staticClass:"gridFullPage"},[e("b-row",[e("b-col",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-navbar-nav",[e("router-link",{attrs:{to:{path:"/"}}},[e("b-button",{staticClass:"my-2 my-sm-0",attrs:{size:"",variant:"outline-danger",type:"submit"}},[t._v("Home")])],1)],1),t._v(" "),e("b-collapse",{attrs:{"is-nav":"",id:"nav_collapse"}})],1)],1)],1),t._v(" "),e("b-row",[e("b-col",[e("div",{staticClass:"fullRegistrationForm"},[e("p"),t._v(" "),t.show?e("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[e("b-form-group",{attrs:{id:"inputUserNameGroup",label:"Имя пользователя:","label-for":"inputUserName",description:"Имя пользователя должно содержать, как минимум 3 буквы"}},[e("b-form-input",{attrs:{id:"inputUserName",type:"text",required:"",placeholder:"Введите имя пользователя"},model:{value:t.form.username,callback:function(a){t.$set(t.form,"username","string"==typeof a?a.trim():a)},expression:"form.username"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputPasswordGroup",label:"Введите пароль:","label-for":"inputPassword",description:"Пароль должен состоять из ..."}},[e("b-form-input",{attrs:{id:"inputPassword",type:"password",required:"",placeholder:"Введите пароль"},model:{value:t.form.password,callback:function(a){t.$set(t.form,"password","string"==typeof a?a.trim():a)},expression:"form.password"}}),t._v(" "),e("b-form-input",{attrs:{id:"inputRePassword",type:"password",required:"",placeholder:"Повторите пароль"},model:{value:t.form.repassword,callback:function(a){t.$set(t.form,"repassword","string"==typeof a?a.trim():a)},expression:"form.repassword"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputEmailGroup",label:"Введите e-mail:","label-for":"inputEmail"}},[e("b-form-input",{attrs:{id:"inputEmail",type:"email",required:"",placeholder:"Введите e-mail"},model:{value:t.form.email,callback:function(a){t.$set(t.form,"email",a)},expression:"form.email"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputFirstLastNameGroup",label:"Введите вашу Фамилию и Имя","label-for":"inputFirstLastName",description:"Поля Фамилия и Имя можно оставить пустыми"}},[e("b-form-input",{attrs:{id:"inpurtFirstName",type:"text",placeholder:"Введите имя"},model:{value:t.form.firstname,callback:function(a){t.$set(t.form,"firstname","string"==typeof a?a.trim():a)},expression:"form.firstname"}}),t._v(" "),e("b-form-input",{attrs:{id:"inputLastName",type:"text",placeholder:"Введите фамилию"},model:{value:t.form.lastname,callback:function(a){t.$set(t.form,"lastname","string"==typeof a?a.trim():a)},expression:"form.lastname"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputSexGroup",label:"Ваш пол:","label-for":"inputSex"}},[e("b-form-select",{attrs:{id:"exampleInput3",options:t.sex},model:{value:t.form.sex,callback:function(a){t.$set(t.form,"sex",a)},expression:"form.sex"}})],1),t._v(" "),e("b-button",{attrs:{type:"submit",variant:"primary"}},[t._v("Подтвердить")]),t._v(" "),e("b-button",{attrs:{type:"reset",variant:"danger"}},[t._v("Сбросить введенные данные")])],1):t._e()],1)]),t._v(" "),e("b-col",[e("p"),t._v(" "),e("h1",[t._v("Здесь что-то будет")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")])])],1)],1),t._v(" "),e("p"),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var h=e("VU/8")(_,b,!1,function(t){e("NPdS")},null,null).exports,g={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"personalPage"},[e("b-container",{staticClass:"gridFullPage"},[e("b-row",[e("b-col",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-navbar-nav",[e("router-link",{attrs:{to:{path:"/"}}},[e("b-button",{staticClass:"my-2 my-sm-0",attrs:{size:"",variant:"outline-danger",type:"submit"}},[t._v("Home")])],1)],1),t._v(" "),e("b-collapse",{attrs:{"is-nav":"",id:"nav_collapse"}}),t._v(" "),e("b-navbar-nav",{staticClass:"ml-auto"},[e("b-nav-form",[e("b-form-input",{staticClass:"mr-sm-2",attrs:{size:"sm",type:"text",placeholder:"Search"}}),t._v(" "),e("b-button",{staticClass:"my-2 my-sm-0",attrs:{size:"sm",type:"submit"}},[t._v("Search")])],1)],1),t._v(" "),e("b-nav-item-dropdown",{attrs:{right:""}},[e("template",{slot:"button-content"},[e("em",[t._v(t._s())])]),t._v(" "),e("b-dropdown-item",{attrs:{href:"#"}},[t._v("Profile")]),t._v(" "),e("b-dropdown-item",{attrs:{href:"#"}},[t._v("Signout")])],2)],1)],1)],1)],1)],1)},staticRenderFns:[]};var w=e("VU/8")({},g,!1,function(t){e("hN6o")},null,null).exports;s.a.use(i.a);var y=new i.a({routes:[{path:"/",name:"Home",component:d},{path:"/registration",name:"registration",component:h},{path:"/profile",name:"profile",component:w}]}),k=e("mebF"),x=e.n(k),C=e("e6fC");e("Jmt5"),e("9M+g"),e("R5w9");s.a.use(C.a),s.a.use(x.a),s.a.config.productionTip=!1,new s.a({el:"#app",router:y,components:{App:n},template:"<App/>"})},NPdS:function(t,a){},R5w9:function(t,a){},epkc:function(t,a){},gsu9:function(t,a){},hN6o:function(t,a){},zj2Q:function(t,a){}},["NHnr"]);
//# sourceMappingURL=app.fd92f54fd5faef7bfb18.js.map