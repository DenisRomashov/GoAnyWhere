webpackJsonp([1],{"+5Wx":function(t,a){},"0RXT":function(t,a){},"1/oy":function(t,a){},"7srp":function(t,a){},"9M+g":function(t,a){},IY3d:function(t,a){},Id91:function(t,a){},Jmt5:function(t,a){},MtIM:function(t,a){},NHnr:function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var r=e("7+uW"),s={render:function(){var t=this.$createElement,a=this._self._c||t;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},staticRenderFns:[]};var n=e("VU/8")({name:"App"},s,!1,function(t){e("gsu9")},null,null).exports,o=e("/ocq"),i=e("mtWM"),l=e.n(i),v=e("Rf8U"),c=e.n(v),u={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-carousel",{staticStyle:{"text-shadow":"1px 1px 2px #333"},attrs:{id:"carousel1",controls:"",indicators:"",background:"#ababab",interval:4e3,"img-width":"1024","img-height":"480"},on:{"sliding-start":t.onSlideStart,"sliding-end":t.onSlideEnd},model:{value:t.slide,callback:function(a){t.slide=a},expression:"slide"}},[e("b-carousel-slide",{staticClass:"slide1",attrs:{caption:"GoAnyWhere - Click & Meet",text:"Найди то, что тебе по душе!","img-blank":"","img-alt":"Blank image"}},[e("router-link",{attrs:{to:{path:"registration"}}},[e("b-button",{attrs:{size:"",variant:"danger"}},[t._v("Регистрация")])],1)],1),t._v(" "),e("b-carousel-slide",{staticClass:"slide2",attrs:{"img-blank":"","img-alt":"Blank image"}},[e("h1",[t._v("GoAnyWhere Project 2018 ©")]),t._v(" "),e("h3",[t._v("Делай, учись, делись, меняй (do, learn, share, change)")])]),t._v(" "),e("b-carousel-slide",{staticClass:"slide3",attrs:{"img-blank":"","img-alt":"Blank image"}}),t._v(" "),e("b-carousel-slide",{staticClass:"slide4",attrs:{caption:"Делай что-нибудь","img-blank":"","img-alt":"Blank image"}},[e("p",[t._v("\n        Это значит, что нельзя сидеть на месте и ждать, пока другой реализует интересную идею,\n        родившуюся у тебя в голове. Какой бы сумасбродной ни была мысль – делись ею, ищи единомышленников,\n        думайте как реализовать ее, встречайтесь, организовывайте.\n        Самое главное – это понять, что ты не одинок и в любом случае найдутся люди, готовые тебя поддержать.\n      ")])])],1)],1)},staticRenderFns:[]};var m=e("VU/8")({data:function(){return{slide:0,sliding:null}},methods:{onSlideStart:function(t){this.sliding=!0},onSlideEnd:function(t){this.sliding=!1}}},u,!1,function(t){e("epkc")},null,null).exports,f={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"content"},[e("link",{attrs:{rel:"stylesheet",href:"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"}}),t._v(" "),e("footer",{attrs:{id:"myFooter"}},[e("div",{staticClass:"container"},[e("div",{staticClass:"row"},[e("div",{staticClass:"col-sm-3"},[e("h2",{staticClass:"logo"},[e("a",{attrs:{href:"/"}},[t._v(" GAW ")])]),t._v(" "),e("h3",[t._v("GoAnyWhere")]),t._v(" "),e("p",[t._v("Click & meet")])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("Get started")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("Главная")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Зарегистрироваться")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Войти")])])])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("About us")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("Информация о нас")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Контакты")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Reviews")])])])]),t._v(" "),e("div",{staticClass:"col-sm-2"},[e("h5",[t._v("Support")]),t._v(" "),e("ul",[e("li",[e("a",{attrs:{href:"#"}},[t._v("FAQ")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Help desk")])]),t._v(" "),e("li",[e("a",{attrs:{href:"#"}},[t._v("Forums")])])])]),t._v(" "),e("div",{staticClass:"col-sm-3"},[e("div",{staticClass:"social-networks"},[e("a",{staticClass:"instagram",attrs:{href:"#"}},[e("i",{staticClass:"fa fa-instagram"})]),t._v(" "),e("a",{staticClass:"github",attrs:{href:"https://github.com",target:"_blank"}},[e("i",{staticClass:"fa fa-github"})]),t._v(" "),e("a",{staticClass:"vk",attrs:{href:"#"}},[e("i",{staticClass:"fa fa-vk"})])]),t._v(" "),e("button",{staticClass:"btn btn-default",attrs:{type:"button"}},[t._v("Связаться")])])])]),t._v(" "),e("div",{staticClass:"footer-copyright"},[e("p",[t._v("© GoAnyWhere Project 2018\n              "),e("a",{staticClass:"github",attrs:{href:"https://github.com",target:"_blank"}},[e("i",{staticClass:"fa fa-github"})])])])])])}]};var b=e("VU/8")({},f,!1,function(t){e("nJoS")},null,null).exports,p={data:function(){return{form:{username:"",password:""},show:!0,test:""}},methods:{onSubmit:function(t){var a=this;t.preventDefault(),l.a.post("/auth",this.form).then(function(t){if(console.log(t),t.data.id>0){a.test=t.data.id;t.data.id;U.push({path:"profile"})}else alert("Неверный пароль или вы еще не зарегистрированы!"),a.form.username="",a.form.password="",a.test=t.data}).catch(function(t){alert("Error..."),console.log(t)})}},router:U,components:{Carousel:m,footerone:b}},d={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-button",{attrs:{size:"",variant:"outline-danger",href:"#about"}},[t._v("О нас")]),t._v(" "),e("b-navbar-nav",{staticClass:"ml-auto"},[e("div",[t.show?e("b-form",{attrs:{inline:""},on:{submit:t.onSubmit}},[e("label",{staticClass:"sr-only",attrs:{for:"inlineInputUsername"}},[t._v("Username")]),t._v(" "),e("b-input",{staticClass:"xs-2 mr-sm-2 mb-sm-0",attrs:{id:"inlineInputUsername",type:"text",placeholder:"Username"},model:{value:t.form.username,callback:function(a){t.$set(t.form,"username","string"==typeof a?a.trim():a)},expression:"form.username"}}),t._v(" "),e("label",{staticClass:"sr-only",attrs:{for:"inlineInputPassword"}},[t._v("Password")]),t._v(" "),e("b-input-group",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{left:"@"}},[e("b-input",{attrs:{id:"inlineInputPassword",type:"password",placeholder:"Password"},model:{value:t.form.password,callback:function(a){t.$set(t.form,"password",a)},expression:"form.password"}})],1),t._v(" "),e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",type:"submit",variant:"outline-primary"}},[t._v("Войти")]),t._v(" "),e("router-link",{attrs:{to:{path:"registration"}}},[e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",variant:"outline-danger"}},[t._v("Регистрация")])],1)],1):t._e()],1)])],1),t._v(" "),e("carousel",{attrs:{id:"Carousel"}}),t._v(" "),e("h1",[t._v(t._s(t.test))]),t._v(" "),e("a",{attrs:{name:"about"}}),t._v(" "),e("b-jumbotron",{attrs:{"bg-variant":"danger","text-variant":"white","border-variant":"dark"}},[e("template",{slot:"header"},[t._v("\n            Наша цель!\n        ")]),t._v(" "),e("template",{slot:"lead"},[t._v("\n            Предоставить людям простые и понятные инструменты для организации неформальных встреч на самые различные темы:\n            политика, книги, игры, кино, здоровье, домашние любимцы, карьера, технологии и т.д.\n        ")]),t._v(" "),e("hr",{staticClass:"my-4"}),t._v(" "),e("p",[t._v("\n            А вы знали? "),e("br"),t._v(" "),e("br"),t._v("Идея митапов возникла задолго до того, как появился Интернет.\n            Однако само слово в известном нам значении стало употребляться с 2001 года!\n        ")])],2),t._v(" "),e("b-jumbotron",{attrs:{"bg-variant":"outline-danger",header:"Делай что-нибудь!",id:"jumbotron2"}},[e("p",[t._v("Это значит, что нельзя сидеть на месте и ждать, пока другой реализует интересную идею,\n          родившуюся у тебя в голове. "),e("br"),t._v(" Какой бы сумасбродной ни была мысль – делись ею, ищи единомышленников,\n          думайте как реализовать ее, встречайтесь, организовывайте.\n          "),e("br"),t._v("Самое главное – это понять, что ты не одинок и в любом случае найдутся люди, готовые тебя поддержать.")]),t._v(" "),e("router-link",{attrs:{to:{path:"registration"}}},[e("b-btn",{attrs:{variant:"danger",size:"lg"}},[t._v("Регистрируйся прямо сейчас!")])],1)],1),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var _=e("VU/8")(p,d,!1,function(t){e("XElQ")},null,null).exports,h={data:function(){return{form:{username:"",password:"",repassword:"",email:"",firstname:"",lastname:""},sex:[{text:"Выбирите пол"},"male","female"],show:!0}},methods:{onSubmit:function(t){t.preventDefault(),l.a.post("/register",this.form).then(function(t){console.log(t)}).catch(function(t){alert("Error..."),console.log(t)})},onReset:function(t){var a=this;t.preventDefault(),this.form.username="",this.form.password="",this.form.repassword="",this.form.email="",this.form.firstname="",this.form.lastname="",this.form.sex=null,this.show=!1,this.$nextTick(function(){a.show=!0})}},components:{footerone:b}},g={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("b-container",{staticClass:"gridFullPage"},[e("b-row",[e("b-col",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-navbar-nav",[e("router-link",{attrs:{to:{path:"/"}}},[e("b-button",{staticClass:"my-2 my-sm-0",attrs:{size:"",variant:"outline-danger",type:"submit"}},[t._v("Home")])],1)],1),t._v(" "),e("b-collapse",{attrs:{"is-nav":"",id:"nav_collapse"}})],1)],1)],1),t._v(" "),e("b-row",[e("b-col",[e("div",{staticClass:"fullRegistrationForm"},[e("p"),t._v(" "),t.show?e("b-form",{on:{submit:t.onSubmit,reset:t.onReset}},[e("b-form-group",{attrs:{id:"inputUserNameGroup",label:"Имя пользователя:","label-for":"inputUserName",description:"Имя пользователя должно содержать, как минимум 3 буквы"}},[e("b-form-input",{attrs:{id:"inputUserName",type:"text",required:"",placeholder:"Введите имя пользователя"},model:{value:t.form.username,callback:function(a){t.$set(t.form,"username","string"==typeof a?a.trim():a)},expression:"form.username"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputPasswordGroup",label:"Введите пароль:","label-for":"inputPassword",description:"Пароль должен состоять из ..."}},[e("b-form-input",{attrs:{id:"inputPassword",type:"password",required:"",placeholder:"Введите пароль"},model:{value:t.form.password,callback:function(a){t.$set(t.form,"password","string"==typeof a?a.trim():a)},expression:"form.password"}}),t._v(" "),e("b-form-input",{attrs:{id:"inputRePassword",type:"password",required:"",placeholder:"Повторите пароль"},model:{value:t.form.repassword,callback:function(a){t.$set(t.form,"repassword","string"==typeof a?a.trim():a)},expression:"form.repassword"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputEmailGroup",label:"Введите e-mail:","label-for":"inputEmail"}},[e("b-form-input",{attrs:{id:"inputEmail",type:"email",required:"",placeholder:"Введите e-mail"},model:{value:t.form.email,callback:function(a){t.$set(t.form,"email",a)},expression:"form.email"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputFirstLastNameGroup",label:"Введите вашу Фамилию и Имя","label-for":"inputFirstLastName",description:"Поля Фамилия и Имя можно оставить пустыми"}},[e("b-form-input",{attrs:{id:"inpurtFirstName",type:"text",placeholder:"Введите имя"},model:{value:t.form.firstname,callback:function(a){t.$set(t.form,"firstname","string"==typeof a?a.trim():a)},expression:"form.firstname"}}),t._v(" "),e("b-form-input",{attrs:{id:"inputLastName",type:"text",placeholder:"Введите фамилию"},model:{value:t.form.lastname,callback:function(a){t.$set(t.form,"lastname","string"==typeof a?a.trim():a)},expression:"form.lastname"}})],1),t._v(" "),e("b-form-group",{attrs:{id:"inputSexGroup",label:"Ваш пол:","label-for":"inputSex"}},[e("b-form-select",{attrs:{id:"exampleInput3",options:t.sex},model:{value:t.form.sex,callback:function(a){t.$set(t.form,"sex",a)},expression:"form.sex"}})],1),t._v(" "),e("b-button",{attrs:{type:"submit",variant:"primary"}},[t._v("Подтвердить")]),t._v(" "),e("b-button",{attrs:{type:"reset",variant:"danger"}},[t._v("Сбросить введенные данные")])],1):t._e()],1)]),t._v(" "),e("b-col",[e("p"),t._v(" "),e("h1",[t._v("Здесь что-то будет")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")]),t._v(" "),e("p",[t._v("|")])])],1)],1),t._v(" "),e("p"),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var w=e("VU/8")(h,g,!1,function(t){e("MtIM")},null,null).exports,C={data:function(){return{form:{name:""},showCreation:!0,showAll:!1,showProfile:!1}},methods:{},components:{footerone:b}},k={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"profilepage"},[e("b-container",{staticClass:"gridFullPage"},[e("b-row",[e("b-col",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-navbar-nav",[e("router-link",{attrs:{to:{path:"/"}}},[e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",variant:"outline-danger",type:"submit"}},[t._v("Home")])],1)],1),t._v(" "),e("b-form-input",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",type:"text",placeholder:"Поиск"}}),t._v(" "),e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",type:"submit",variant:"warning"}},[t._v(" Поиск ")]),t._v(" "),e("b-collapse",{attrs:{"is-nav":"",id:"nav_collapse"}}),t._v(" "),e("b-navbar-nav",{staticClass:"ml-auto"},[e("b-nav-form")],1)],1)],1)],1),t._v(" "),e("div",{staticClass:"BlockAfterNavbar"},[e("b-row",{attrs:{id:"FirstRow"}},[e("b-col"),t._v(" "),e("b-col",{attrs:{cols:"10"}},[e("div",{attrs:{id:"ButtonRow"}},[e("b-button-group",{attrs:{size:"lg",variant:"warning"}},[e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!0,t.showAll=!1,t.showProfile=!1}}},[t._v("Создать событие")]),t._v(" "),e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!1,t.showAll=!0,t.showProfile=!1}}},[t._v("Все события")]),t._v(" "),e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!1,t.showAll=!1,t.showProfile=!0}}},[t._v("Профиль")])],1)],1)]),t._v(" "),e("b-col")],1),t._v(" "),e("b-row",[e("b-col"),t._v(" "),t.showCreation?e("b-container",{attrs:{id:"creationMeeting"}},[e("b-col",{attrs:{cols:"10"}},[e("b-form",[e("h1",[t._v("Создание события")])])],1)],1):t._e(),t._v(" "),t.showAll?e("b-container",{attrs:{id:"creationMeeting"}},[e("b-col",{attrs:{cols:"10"}},[e("b-form",[e("h1",[t._v("Все события")])])],1)],1):t._e(),t._v(" "),t.showProfile?e("b-container",{attrs:{id:"creationMeeting"}},[e("b-col",{attrs:{cols:"10"}},[e("b-form",[e("h1",[t._v("Профиль")])])],1)],1):t._e(),t._v(" "),e("b-col")],1)],1)],1),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var x=e("VU/8")(C,k,!1,function(t){e("0RXT")},null,null).exports,y={render:function(){var t=this.$createElement;return(this._self._c||t)("h1",[this._v("allMeetings.vue")])},staticRenderFns:[]};var P={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"createMeeting"},[a("h1",[this._v("createMeeting.vue")])])}]};var E={data:function(){return{create:" [ Empty.. ]"}},methods:{testGet:function(){var t=this;l.a.get("/user?id=17").then(function(a){t.create=a}).catch(function(t){alert("Error..."),console.log(t)})}}},A={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{},[e("h1",[t._v("Profile.vue")]),t._v(" "),e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.testGet()}}},[t._v("TEST")]),t._v(" "),e("h1",[t._v(t._s(t.create))])],1)},staticRenderFns:[]};var F={data:function(){return{form:{name:""},showCreation:!1,showAll:!1,showProfile:!0}},methods:{},components:{footerone:b,allMeetings:e("VU/8")({},y,!1,function(t){e("IY3d")},null,null).exports,createMeeting:e("VU/8")({data:function(){return{}},methods:{}},P,!1,function(t){e("7srp")},null,null).exports,profile:e("VU/8")(E,A,!1,function(t){e("wEed")},null,null).exports}},R={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"profilepage"},[e("b-container",{staticClass:"gridFullPage",attrs:{fluid:""}},[e("b-row",[e("b-col",[e("b-navbar",{attrs:{toggleable:"md",type:"dark",variant:"dark",fixed:"top"}},[e("b-navbar-toggle",{attrs:{target:"nav_collapse"}}),t._v(" "),e("b-navbar-brand",{attrs:{href:"/"}},[t._v("GoAnyWhere")]),t._v(" "),e("b-navbar-nav",[e("router-link",{attrs:{to:{path:"/"}}},[e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",variant:"outline-danger",type:"submit"}},[t._v("Home")])],1)],1),t._v(" "),e("b-form-input",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",type:"text",placeholder:"Поиск"}}),t._v(" "),e("b-button",{staticClass:"mb-2 mr-sm-2 mb-sm-0",attrs:{size:"",type:"submit",variant:"warning"}},[t._v(" Поиск ")]),t._v(" "),e("b-collapse",{attrs:{"is-nav":"",id:"nav_collapse"}}),t._v(" "),e("b-navbar-nav",{staticClass:"ml-auto"},[e("b-nav-form")],1)],1)],1)],1),t._v(" "),e("div",{staticClass:"BlockAfterNavbar"},[e("b-row",{attrs:{id:"FirstRow"}},[e("b-col"),t._v(" "),e("b-col",{attrs:{cols:"10"}},[e("div",{attrs:{id:"ButtonRow"}},[e("b-button-group",{attrs:{size:"lg",variant:"warning"}},[e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!1,t.showAll=!1,t.showProfile=!0}}},[t._v("Профиль")]),t._v(" "),e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!1,t.showAll=!0,t.showProfile=!1}}},[t._v("Все события")]),t._v(" "),e("b-button",{attrs:{variant:"dark"},on:{click:function(a){t.showCreation=!0,t.showAll=!1,t.showProfile=!1}}},[t._v("Создать событие")])],1)],1)]),t._v(" "),e("b-col")],1),t._v(" "),e("b-row",[e("b-col"),t._v(" "),e("b-col",{attrs:{cols:"10"}},[t.showAll?e("allMeetings"):t._e(),t._v(" "),t.showCreation?e("createMeeting"):t._e(),t._v(" "),t.showProfile?e("profile"):t._e()],1),t._v(" "),e("b-col")],1)],1)],1),t._v(" "),e("footerone")],1)},staticRenderFns:[]};var $=e("VU/8")(F,R,!1,function(t){e("+5Wx")},null,null).exports,S={render:function(){var t=this.$createElement,a=this._self._c||t;return a("div",{staticClass:"notfound"},[a("div",{staticClass:"block"},[a("h1",[this._v("404!")]),this._v(" "),a("h1",[this._v("OOOPPPSSS!!!!")]),this._v(" "),a("h2",[this._v("У нас нет такой страницы :( ")]),this._v(" "),a("div",[a("router-link",{attrs:{to:{path:"/"}}},[a("b-button",{attrs:{size:"lg",variant:"warning"}},[this._v("Пошли на главную!")])],1)],1)])])},staticRenderFns:[]};var M=e("VU/8")({},S,!1,function(t){e("xnLX")},null,null).exports;r.a.use(o.a);var U=new o.a({routes:[{path:"/",name:"Home",component:_},{path:"/home",name:"Home",component:_},{path:"/registration",name:"registration",component:w},{path:"/pr",name:"pr",component:x},{path:"/profile",name:"profile",component:$},{path:"*",component:M}]}),G=(e("mebF"),e("e6fC"));e("Jmt5"),e("9M+g");r.a.use(G.a),r.a.use(c.a,l.a),r.a.config.productionTip=!1,new r.a({el:"#app",router:U,components:{App:n},template:"<App/>"})},XElQ:function(t,a){},epkc:function(t,a){},gsu9:function(t,a){},nJoS:function(t,a){},wEed:function(t,a){},xnLX:function(t,a){},zj2Q:function(t,a){}},["NHnr"]);
//# sourceMappingURL=app.55f43d0f64772d55d355.js.map