(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{NulH:function(t,c,e){"use strict";e.r(c);var a=e("tyNb"),n=e("0BIi"),o=e("NuY5"),i=e("3Pt+"),s=e("XNiG"),l=e("1G5W"),r=e("Kj3r"),d=e("/uUt"),b=e("HY3y"),m=e("0Zs5");class u{constructor(t){this.id=t.id||m.a.generateGUID(),this.name=t.name||"",this.lastName=t.lastName||"",this.avatar=t.avatar||"assets/images/avatars/profile.jpg",this.nickname=t.nickname||"",this.company=t.company||"",this.jobTitle=t.jobTitle||"",this.email=t.email||"",this.phone=t.phone||"",this.address=t.address||"",this.birthday=t.birhday||"",this.notes=t.notes||""}}var h=e("0IaG"),f=e("fXoL"),p=e("/t3+"),g=e("XiUz"),C=e("bTqV"),x=e("NFeN"),v=e("cpli"),w=e("kmnG"),y=e("qFsG"),S=e("iadO"),_=e("ofXK");function k(t,c){if(1&t){const t=f.dc();f.cc(0,"button",30),f.oc("click",(function(){f.Qc(t);const c=f.sc();return c.matDialogRef.close(c.contactForm)})),f.ad(1," SAVE "),f.bc()}if(2&t){const t=f.sc();f.zc("disabled",t.contactForm.invalid)}}function D(t,c){if(1&t){const t=f.dc();f.cc(0,"button",30),f.oc("click",(function(){f.Qc(t);const c=f.sc();return c.matDialogRef.close(["save",c.contactForm])})),f.ad(1," SAVE "),f.bc()}if(2&t){const t=f.sc();f.zc("disabled",t.contactForm.invalid)}}function H(t,c){if(1&t){const t=f.dc();f.cc(0,"button",31),f.oc("click",(function(){f.Qc(t);const c=f.sc();return c.matDialogRef.close(["delete",c.contactForm])})),f.cc(1,"mat-icon"),f.ad(2,"delete"),f.bc(),f.bc()}}let A=(()=>{class t{constructor(t,c,e){this.matDialogRef=t,this._data=c,this._formBuilder=e,this.action=c.action,"edit"===this.action?(this.dialogTitle="Edit Contact",this.contact=c.contact):(this.dialogTitle="New Contact",this.contact=new u({})),this.contactForm=this.createContactForm()}createContactForm(){return this._formBuilder.group({id:[this.contact.id],name:[this.contact.name],lastName:[this.contact.lastName],avatar:[this.contact.avatar],nickname:[this.contact.nickname],company:[this.contact.company],jobTitle:[this.contact.jobTitle],email:[this.contact.email],phone:[this.contact.phone],address:[this.contact.address],birthday:[this.contact.birthday],notes:[this.contact.notes]})}}return t.\u0275fac=function(c){return new(c||t)(f.Wb(h.f),f.Wb(h.a),f.Wb(i.c))},t.\u0275cmp=f.Qb({type:t,selectors:[["contacts-contact-form-dialog"]],decls:69,vars:11,consts:[[1,"dialog-content-wrapper"],["matDialogTitle","",1,"mat-accent","m-0"],["fxLayout","row","fxLayoutAlign","space-between center"],[1,"title","dialog-title"],["mat-icon-button","","aria-label","Close dialog",3,"click"],["fxLayout","column","fxLayoutAlign","center center",1,"toolbar-bottom","py-16"],[1,"avatar","contact-avatar","huge","m-0",3,"src","alt"],[1,"contact-name","mt-8"],["mat-dialog-content","","persoInfoPerfectScrollbar","",1,"p-24","m-0"],[3,"formGroup"],["fxLayout","row","fxLayoutAlign","start start",1,"mb-24"],["fxFlex",""],["matPrefix","",1,"mr-12","s-20","secondary-text"],["name","name","formControlName","name","placeholder","Name","matInput","","required",""],["name","lastName","formControlName","lastName","placeholder","Lastname","matInput",""],["name","nickname","formControlName","nickname","matInput","","placeholder","Nickname"],["formControlName","phone","matInput","","placeholder","Phone number"],["name","email","formControlName","email","matInput","","type","email","placeholder","Email"],["name","company","formControlName","company","matInput","","placeholder","Company"],["name","jobTitle","formControlName","jobTitle","matInput","","placeholder","Job title"],["fxFlex","",1,"mr-24"],["matInput","","placeholder","Birthday",3,"matDatepicker"],["matSuffix","",3,"for"],["birthdayDatePicker",""],["name","address","formControlName","address","matInput","","placeholder","Address"],["fxLayout","row","fxLayoutAlign","start start",1,"textarea-wrapper"],["name","notes","formControlName","notes","placeholder","Notes","matInput","","type","text","max-rows","4"],["mat-dialog-actions","","fxLayout","row","fxLayoutAlign","space-between center",1,"m-0","p-16"],["mat-raised-button","","class","save-button mat-accent","aria-label","SAVE",3,"disabled","click",4,"ngIf"],["mat-icon-button","","aria-label","Delete","matTooltip","Delete",3,"click",4,"ngIf"],["mat-raised-button","","aria-label","SAVE",1,"save-button","mat-accent",3,"disabled","click"],["mat-icon-button","","aria-label","Delete","matTooltip","Delete",3,"click"]],template:function(t,c){if(1&t&&(f.cc(0,"div",0),f.cc(1,"mat-toolbar",1),f.cc(2,"mat-toolbar-row",2),f.cc(3,"span",3),f.ad(4),f.bc(),f.cc(5,"button",4),f.oc("click",(function(){return c.matDialogRef.close()})),f.cc(6,"mat-icon"),f.ad(7,"close"),f.bc(),f.bc(),f.bc(),f.cc(8,"mat-toolbar-row",5),f.Xb(9,"img",6),f.cc(10,"div",7),f.ad(11),f.bc(),f.bc(),f.bc(),f.cc(12,"div",8),f.cc(13,"form",9),f.cc(14,"div",10),f.cc(15,"mat-form-field",11),f.cc(16,"mat-icon",12),f.ad(17,"account_circle"),f.bc(),f.Xb(18,"input",13),f.bc(),f.bc(),f.cc(19,"div",10),f.cc(20,"mat-form-field",11),f.cc(21,"mat-icon",12),f.ad(22,"account_circle"),f.bc(),f.Xb(23,"input",14),f.bc(),f.bc(),f.cc(24,"div",10),f.cc(25,"mat-form-field",11),f.cc(26,"mat-icon",12),f.ad(27,"star"),f.bc(),f.Xb(28,"input",15),f.bc(),f.bc(),f.cc(29,"div",10),f.cc(30,"mat-form-field",11),f.cc(31,"mat-icon",12),f.ad(32,"phone"),f.bc(),f.Xb(33,"input",16),f.bc(),f.bc(),f.cc(34,"div",10),f.cc(35,"mat-form-field",11),f.cc(36,"mat-icon",12),f.ad(37,"email"),f.bc(),f.Xb(38,"input",17),f.bc(),f.bc(),f.cc(39,"div",10),f.cc(40,"mat-form-field",11),f.cc(41,"mat-icon",12),f.ad(42,"domain"),f.bc(),f.Xb(43,"input",18),f.bc(),f.bc(),f.cc(44,"div",10),f.cc(45,"mat-form-field",11),f.cc(46,"mat-icon",12),f.ad(47,"work"),f.bc(),f.Xb(48,"input",19),f.bc(),f.bc(),f.cc(49,"div",10),f.cc(50,"mat-form-field",20),f.cc(51,"mat-icon",12),f.ad(52,"cake"),f.bc(),f.Xb(53,"input",21),f.Xb(54,"mat-datepicker-toggle",22),f.Xb(55,"mat-datepicker",null,23),f.bc(),f.bc(),f.cc(57,"div",10),f.cc(58,"mat-form-field",11),f.cc(59,"mat-icon",12),f.ad(60,"home"),f.bc(),f.Xb(61,"input",24),f.bc(),f.bc(),f.cc(62,"div",25),f.cc(63,"mat-form-field",11),f.Xb(64,"textarea",26),f.bc(),f.bc(),f.bc(),f.bc(),f.cc(65,"div",27),f.Yc(66,k,2,1,"button",28),f.Yc(67,D,2,1,"button",28),f.Yc(68,H,3,0,"button",29),f.bc(),f.bc()),2&t){const t=f.Mc(56);f.Hb(4),f.bd(c.dialogTitle),f.Hb(5),f.zc("src",c.contact.avatar,f.Sc)("alt",c.contact.name),f.Hb(2),f.dd("",c.contact.name," ",c.contact.lastName,""),f.Hb(2),f.zc("formGroup",c.contactForm),f.Hb(40),f.zc("matDatepicker",t),f.Hb(1),f.zc("for",t),f.Hb(12),f.zc("ngIf","edit"!==c.action),f.Hb(1),f.zc("ngIf","edit"===c.action),f.Hb(1),f.zc("ngIf","edit"===c.action)}},directives:[p.a,p.c,g.e,g.d,C.b,x.a,v.a,i.x,i.p,i.h,w.b,g.b,w.f,i.b,y.b,i.o,i.f,i.u,S.b,S.d,w.g,S.a,_.u],styles:[".contact-form-dialog{width:400px}@media screen and (max-width:599px){.contact-form-dialog{width:100%}}.contact-form-dialog .mat-dialog-container{padding:0}.contact-form-dialog .mat-dialog-container .mat-toolbar{flex:1 0 auto;min-height:0}.contact-form-dialog .mat-dialog-container .toolbar-bottom{height:auto}.contact-form-dialog .dialog-content-wrapper{max-height:85vh;display:flex;flex-direction:column}"],encapsulation:2}),t})();var O=e("2Vo4"),I=e("tk/3");let M=(()=>{class t{constructor(t){this._httpClient=t,this.selectedContacts=[],this.onContactsChanged=new O.a([]),this.onSelectedContactsChanged=new O.a([]),this.onUserDataChanged=new O.a([]),this.onSearchTextChanged=new s.a,this.onFilterChanged=new s.a}resolve(t,c){return new Promise((t,c)=>{Promise.all([this.getContacts(),this.getUserData()]).then(([c])=>{this.onSearchTextChanged.subscribe(t=>{this.searchText=t,this.getContacts()}),this.onFilterChanged.subscribe(t=>{this.filterBy=t,this.getContacts()}),t()},c)})}getContacts(){return new Promise((t,c)=>{this._httpClient.get("api/contacts-contacts").subscribe(c=>{this.contacts=c,"starred"===this.filterBy&&(this.contacts=this.contacts.filter(t=>this.user.starred.includes(t.id))),"frequent"===this.filterBy&&(this.contacts=this.contacts.filter(t=>this.user.frequentContacts.includes(t.id))),this.searchText&&""!==this.searchText&&(this.contacts=m.a.filterArrayByString(this.contacts,this.searchText)),this.contacts=this.contacts.map(t=>new u(t)),this.onContactsChanged.next(this.contacts),t(this.contacts)},c)})}getUserData(){return new Promise((t,c)=>{this._httpClient.get("api/contacts-user/5725a6802d10e277a0f35724").subscribe(c=>{this.user=c,this.onUserDataChanged.next(this.user),t(this.user)},c)})}toggleSelectedContact(t){if(this.selectedContacts.length>0){const c=this.selectedContacts.indexOf(t);if(-1!==c)return this.selectedContacts.splice(c,1),void this.onSelectedContactsChanged.next(this.selectedContacts)}this.selectedContacts.push(t),this.onSelectedContactsChanged.next(this.selectedContacts)}toggleSelectAll(){this.selectedContacts.length>0?this.deselectContacts():this.selectContacts()}selectContacts(t,c){this.selectedContacts=[],void 0!==t&&void 0!==c||(this.selectedContacts=[],this.contacts.map(t=>{this.selectedContacts.push(t.id)})),this.onSelectedContactsChanged.next(this.selectedContacts)}updateContact(t){return new Promise((c,e)=>{this._httpClient.post("api/contacts-contacts/"+t.id,Object.assign({},t)).subscribe(t=>{this.getContacts(),c(t)})})}updateUserData(t){return new Promise((c,e)=>{this._httpClient.post("api/contacts-user/"+this.user.id,Object.assign({},t)).subscribe(t=>{this.getUserData(),this.getContacts(),c(t)})})}deselectContacts(){this.selectedContacts=[],this.onSelectedContactsChanged.next(this.selectedContacts)}deleteContact(t){const c=this.contacts.indexOf(t);this.contacts.splice(c,1),this.onContactsChanged.next(this.contacts)}deleteSelectedContacts(){for(const t of this.selectedContacts){const c=this.contacts.find(c=>c.id===t),e=this.contacts.indexOf(c);this.contacts.splice(e,1)}this.onContactsChanged.next(this.contacts),this.deselectContacts()}}return t.\u0275fac=function(c){return new(c||t)(f.kc(I.c))},t.\u0275prov=f.Sb({token:t,factory:t.\u0275fac}),t})();var P=e("nS/M"),z=e("2C/K"),L=e("znSr"),F=e("kcHR"),T=e("FKr1");const R=function(t){return{"active mat-accent-bg":t}};let N=(()=>{class t{constructor(t){this._contactsService=t,this._unsubscribeAll=new s.a}ngOnInit(){this.filterBy=this._contactsService.filterBy||"all",this._contactsService.onUserDataChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{this.user=t})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}changeFilter(t){this.filterBy=t,this._contactsService.onFilterChanged.next(this.filterBy)}}return t.\u0275fac=function(c){return new(c||t)(f.Wb(M))},t.\u0275cmp=f.Qb({type:t,selectors:[["contacts-main-sidebar"]],decls:20,vars:12,consts:[[1,"sidebar-content"],[1,"card","mat-white-bg"],["fxLayout","row","fxLayoutAlign","start center",1,"header","p-24"],[1,"avatar","mr-16",3,"src","alt"],[1,"h5"],["persoInfoPerfectScrollbar","",1,"content","py-16"],[1,"nav"],["aria-label","inbox",1,"nav-item"],["matRipple","",1,"nav-link",3,"ngClass","click"],[1,"title"],["aria-label","frequently contacted",1,"nav-item",3,"click"],["matRipple","",1,"nav-link",3,"ngClass"],["aria-label","starred",1,"nav-item",3,"click"]],template:function(t,c){1&t&&(f.cc(0,"div",0),f.cc(1,"div",1),f.cc(2,"div",2),f.Xb(3,"img",3),f.cc(4,"span",4),f.ad(5),f.bc(),f.bc(),f.cc(6,"div",5),f.cc(7,"div",6),f.cc(8,"div",7),f.cc(9,"a",8),f.oc("click",(function(){return c.changeFilter("all")})),f.cc(10,"span",9),f.ad(11,"All Contacts"),f.bc(),f.bc(),f.bc(),f.cc(12,"div",10),f.oc("click",(function(){return c.changeFilter("frequent")})),f.cc(13,"a",11),f.cc(14,"div",9),f.ad(15,"Freequently contacted"),f.bc(),f.bc(),f.bc(),f.cc(16,"div",12),f.oc("click",(function(){return c.changeFilter("starred")})),f.cc(17,"a",11),f.cc(18,"div",9),f.ad(19,"Starred Contacts"),f.bc(),f.bc(),f.bc(),f.bc(),f.bc(),f.bc(),f.bc()),2&t&&(f.Hb(3),f.zc("src",c.user.avatar,f.Sc)("alt",c.user.name),f.Hb(2),f.bd(c.user.name),f.Hb(4),f.zc("ngClass",f.Dc(6,R,"all"===c.filterBy)),f.Hb(4),f.zc("ngClass",f.Dc(8,R,"frequent"===c.filterBy)),f.Hb(4),f.zc("ngClass",f.Dc(10,R,"starred"===c.filterBy)))},directives:[g.e,g.d,v.a,T.r,_.r,L.a],styles:["[_nghost-%COMP%]{display:flex;flex-direction:column;flex:1 0 auto;height:100%}[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]{display:flex;flex-direction:column;padding:0}@media screen and (min-width:960px){[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]{padding:24px 4px 24px 24px}}[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]   .card[_ngcontent-%COMP%]{display:flex;flex-direction:column;flex:0 1 auto;padding:0}@media screen and (min-width:960px){[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]   .card[_ngcontent-%COMP%]{box-shadow:0 2px 4px -1px rgba(0,0,0,.2),0 4px 5px 0 rgba(0,0,0,.14),0 1px 10px 0 rgba(0,0,0,.12)}}[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]   .card[_ngcontent-%COMP%] > .header[_ngcontent-%COMP%]{flex:0 1 auto;border-bottom:1px solid rgba(0,0,0,.12)}[_nghost-%COMP%]   .sidebar-content[_ngcontent-%COMP%]   .card[_ngcontent-%COMP%] > .content[_ngcontent-%COMP%]{flex:0 1 auto}"]}),t})();var Y=e("0EQZ"),j=e("Pm6R"),X=e("+0xr"),Q=e("bSwM"),B=e("STbY");const $=["dialogContent"];function U(t,c){1&t&&f.Xb(0,"mat-header-cell")}function W(t,c){if(1&t){const t=f.dc();f.cc(0,"mat-cell"),f.cc(1,"mat-checkbox",20),f.oc("ngModelChange",(function(e){f.Qc(t);const a=c.$implicit;return f.sc().checkboxes[a.id]=e}))("ngModelChange",(function(){f.Qc(t);const e=c.$implicit;return f.sc().onSelectedChange(e.id)}))("click",(function(c){return f.Qc(t),c.stopPropagation()})),f.bc(),f.bc()}if(2&t){const t=c.$implicit,e=f.sc();f.Hb(1),f.zc("ngModel",e.checkboxes[t.id])}}function Z(t,c){1&t&&f.Xb(0,"mat-header-cell")}function q(t,c){if(1&t&&f.Xb(0,"img",22),2&t){const t=f.sc().$implicit;f.zc("alt",t.name)("src",t.avatar,f.Sc)}}function E(t,c){if(1&t&&(f.cc(0,"mat-cell"),f.Yc(1,q,1,2,"img",21),f.bc()),2&t){const t=c.$implicit;f.Hb(1),f.zc("ngIf",t.avatar)}}function G(t,c){1&t&&(f.cc(0,"mat-header-cell"),f.ad(1,"Name"),f.bc())}function V(t,c){if(1&t&&(f.cc(0,"mat-cell"),f.cc(1,"p",23),f.ad(2),f.bc(),f.bc()),2&t){const t=c.$implicit;f.Hb(2),f.dd("",t.name," ",t.lastName,"")}}function J(t,c){1&t&&(f.cc(0,"mat-header-cell",24),f.ad(1,"Email"),f.bc())}function K(t,c){if(1&t&&(f.cc(0,"mat-cell",24),f.cc(1,"p",25),f.ad(2),f.bc(),f.bc()),2&t){const t=c.$implicit;f.Hb(2),f.cd(" ",t.email," ")}}function tt(t,c){1&t&&(f.cc(0,"mat-header-cell",26),f.ad(1,"Phone"),f.bc())}function ct(t,c){if(1&t&&(f.cc(0,"mat-cell",26),f.cc(1,"p",27),f.ad(2),f.bc(),f.bc()),2&t){const t=c.$implicit;f.Hb(2),f.cd(" ",t.phone," ")}}function et(t,c){1&t&&(f.cc(0,"mat-header-cell",28),f.ad(1,"Job title"),f.bc())}function at(t,c){if(1&t&&(f.cc(0,"mat-cell",28),f.cc(1,"p",29),f.ad(2),f.bc(),f.bc()),2&t){const t=c.$implicit;f.Hb(2),f.cd(" ",t.jobTitle," ")}}function nt(t,c){1&t&&(f.cc(0,"mat-header-cell",28),f.ad(1,"Company"),f.bc())}function ot(t,c){if(1&t&&(f.cc(0,"mat-cell",28),f.cc(1,"p",30),f.ad(2),f.bc(),f.bc()),2&t){const t=c.$implicit;f.Hb(2),f.cd(" ",t.company," ")}}function it(t,c){1&t&&f.Xb(0,"mat-header-cell")}function st(t,c){1&t&&(f.cc(0,"mat-icon",39),f.ad(1,"star"),f.bc())}function lt(t,c){1&t&&(f.cc(0,"mat-icon",36),f.ad(1,"star_outline"),f.bc())}function rt(t,c){if(1&t){const t=f.dc();f.cc(0,"mat-cell"),f.cc(1,"div",31),f.cc(2,"button",32),f.oc("click",(function(e){f.Qc(t);const a=c.$implicit,n=f.sc();return e.stopPropagation(),n.toggleStar(a.id)})),f.Yc(3,st,2,0,"mat-icon",33),f.Yc(4,lt,2,0,"mat-icon",34),f.bc(),f.cc(5,"button",35),f.oc("click",(function(c){return f.Qc(t),c.stopPropagation()})),f.cc(6,"mat-icon",36),f.ad(7,"more_vert"),f.bc(),f.bc(),f.cc(8,"mat-menu",null,37),f.cc(10,"button",38),f.oc("click",(function(){f.Qc(t);const e=c.$implicit;return f.sc().deleteContact(e)})),f.cc(11,"mat-icon"),f.ad(12,"delete"),f.bc(),f.cc(13,"span"),f.ad(14,"Remove"),f.bc(),f.bc(),f.bc(),f.bc(),f.bc()}if(2&t){const t=c.$implicit,e=f.Mc(9),a=f.sc();f.Hb(3),f.zc("ngIf",a.user.starred.includes(t.id)),f.Hb(1),f.zc("ngIf",!a.user.starred.includes(t.id)),f.Hb(1),f.zc("matMenuTriggerFor",e)}}function dt(t,c){1&t&&f.Xb(0,"mat-header-row")}const bt=function(t){return{"mat-accent-50-bg":t}},mt=function(){return{y:"100%"}},ut=function(t){return{value:"*",params:t}};function ht(t,c){if(1&t){const t=f.dc();f.cc(0,"mat-row",40),f.oc("click",(function(){f.Qc(t);const e=c.$implicit;return f.sc().editContact(e)})),f.bc()}if(2&t){const t=c.$implicit,e=f.sc();f.zc("ngClass",f.Dc(2,bt,e.checkboxes[t.id]))("@animate",f.Dc(5,ut,f.Cc(4,mt)))}}const ft=function(){return{value:"50"}};let pt=(()=>{class t{constructor(t,c){this._contactsService=t,this._matDialog=c,this.displayedColumns=["checkbox","avatar","name","email","phone","jobTitle","buttons"],this._unsubscribeAll=new s.a}ngOnInit(){this.dataSource=new gt(this._contactsService),this._contactsService.onContactsChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{this.contacts=t,this.checkboxes={},t.map(t=>{this.checkboxes[t.id]=!1})}),this._contactsService.onSelectedContactsChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{for(const c in this.checkboxes)this.checkboxes.hasOwnProperty(c)&&(this.checkboxes[c]=t.includes(c));this.selectedContacts=t}),this._contactsService.onUserDataChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{this.user=t}),this._contactsService.onFilterChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(()=>{this._contactsService.deselectContacts()})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}editContact(t){this.dialogRef=this._matDialog.open(A,{panelClass:"contact-form-dialog",data:{contact:t,action:"edit"}}),this.dialogRef.afterClosed().subscribe(c=>{if(!c)return;const e=c[1];switch(c[0]){case"save":this._contactsService.updateContact(e.getRawValue());break;case"delete":this.deleteContact(t)}})}deleteContact(t){this.confirmDialogRef=this._matDialog.open(j.a,{disableClose:!1}),this.confirmDialogRef.componentInstance.confirmMessage="Are you sure you want to delete?",this.confirmDialogRef.afterClosed().subscribe(c=>{c&&this._contactsService.deleteContact(t),this.confirmDialogRef=null})}onSelectedChange(t){this._contactsService.toggleSelectedContact(t)}toggleStar(t){this.user.starred.includes(t)?this.user.starred.splice(this.user.starred.indexOf(t),1):this.user.starred.push(t),this._contactsService.updateUserData(this.user)}}return t.\u0275fac=function(c){return new(c||t)(f.Wb(M),f.Wb(h.b))},t.\u0275cmp=f.Qb({type:t,selectors:[["contacts-contact-list"]],viewQuery:function(t,c){var e;1&t&&f.fd($,!0),2&t&&f.Lc(e=f.pc())&&(c.dialogContent=e.first)},decls:28,vars:5,consts:[[3,"dataSource"],["table",""],["matColumnDef","checkbox"],[4,"matHeaderCellDef"],[4,"matCellDef"],["matColumnDef","avatar"],["matColumnDef","name"],["matColumnDef","email"],["fxHide","","fxShow.gt-sm","",4,"matHeaderCellDef"],["fxHide","","fxShow.gt-sm","",4,"matCellDef"],["matColumnDef","phone"],["fxHide","","fxShow.gt-md","",4,"matHeaderCellDef"],["fxHide","","fxShow.gt-md","",4,"matCellDef"],["matColumnDef","jobTitle"],["fxHide","","fxShow.gt-lg","",4,"matHeaderCellDef"],["fxHide","","fxShow.gt-lg","",4,"matCellDef"],["matColumnDef","company"],["matColumnDef","buttons"],[4,"matHeaderRowDef"],["class","contact","matRipple","",3,"ngClass","click",4,"matRowDef","matRowDefColumns"],[3,"ngModel","ngModelChange","click"],["class","avatar",3,"alt","src",4,"ngIf"],[1,"avatar",3,"alt","src"],[1,"text-truncate","font-weight-600"],["fxHide","","fxShow.gt-sm",""],[1,"email","text-truncate"],["fxHide","","fxShow.gt-md",""],[1,"phone","text-truncate"],["fxHide","","fxShow.gt-lg",""],[1,"job-title","text-truncate"],[1,"company","text-truncate"],["fxFlex","row","fxLayoutAlign","end center"],["mat-icon-button","","aria-label","Toggle star",3,"click"],["class","amber-fg",4,"ngIf"],["class","secondary-text",4,"ngIf"],["mat-icon-button","","aria-label","More",3,"matMenuTriggerFor","click"],[1,"secondary-text"],["moreMenu","matMenu"],["mat-menu-item","","aria-label","remove",3,"click"],[1,"amber-fg"],["matRipple","",1,"contact",3,"ngClass","click"]],template:function(t,c){1&t&&(f.cc(0,"mat-table",0,1),f.ac(2,2),f.Yc(3,U,1,0,"mat-header-cell",3),f.Yc(4,W,2,1,"mat-cell",4),f.Zb(),f.ac(5,5),f.Yc(6,Z,1,0,"mat-header-cell",3),f.Yc(7,E,2,1,"mat-cell",4),f.Zb(),f.ac(8,6),f.Yc(9,G,2,0,"mat-header-cell",3),f.Yc(10,V,3,2,"mat-cell",4),f.Zb(),f.ac(11,7),f.Yc(12,J,2,0,"mat-header-cell",8),f.Yc(13,K,3,1,"mat-cell",9),f.Zb(),f.ac(14,10),f.Yc(15,tt,2,0,"mat-header-cell",11),f.Yc(16,ct,3,1,"mat-cell",12),f.Zb(),f.ac(17,13),f.Yc(18,et,2,0,"mat-header-cell",14),f.Yc(19,at,3,1,"mat-cell",15),f.Zb(),f.ac(20,16),f.Yc(21,nt,2,0,"mat-header-cell",14),f.Yc(22,ot,3,1,"mat-cell",15),f.Zb(),f.ac(23,17),f.Yc(24,it,1,0,"mat-header-cell",3),f.Yc(25,rt,15,3,"mat-cell",4),f.Zb(),f.Yc(26,dt,1,0,"mat-header-row",18),f.Yc(27,ht,1,7,"mat-row",19),f.bc()),2&t&&(f.zc("dataSource",c.dataSource)("@animateStagger",f.Cc(4,ft)),f.Hb(26),f.zc("matHeaderRowDef",c.displayedColumns),f.Hb(1),f.zc("matRowDefColumns",c.displayedColumns))},directives:[X.j,X.c,X.e,X.b,X.g,X.i,X.d,X.a,Q.a,i.o,i.r,_.u,L.b,g.b,g.d,C.b,B.c,x.a,B.d,B.a,X.f,X.h,T.r,_.r,L.a],styles:["contacts-contact-list{display:flex;flex:1 1 auto;width:100%}contacts-contact-list .mat-table{width:100%;background:transparent;box-shadow:none}contacts-contact-list .mat-table .mat-column-checkbox{flex:0 1 64px;padding-left:18px}contacts-contact-list .mat-table .mat-column-avatar{flex:0 1 64px}contacts-contact-list .mat-table .mat-column-buttons{flex:0 1 80px}contacts-contact-list .mat-table .mat-row{position:relative;cursor:pointer;padding:8px}contacts-contact-list .mat-table .mat-row .mat-cell{min-width:0}contacts-contact-list .mat-table .mat-row .mat-cell.mat-column-detail-button{flex:0 1 auto;padding:0 24px 0 0}@media screen and (min-width:1280px){contacts-contact-list .mat-table .mat-row .mat-cell.mat-column-detail-button{display:none}}#add-contact-button{position:absolute;bottom:12px;right:12px;padding:0;z-index:99}@media (max-width:599px){#add-contact-button{position:-webkit-sticky;position:sticky;top:calc(100vh - 72px);bottom:auto}}"],encapsulation:2,data:{animation:b.a}}),t})();class gt extends Y.b{constructor(t){super(),this._contactsService=t}connect(){return this._contactsService.onContactsChanged}disconnect(){}}let Ct=(()=>{class t{constructor(t,c){this._contactsService=t,this._matDialog=c,this._unsubscribeAll=new s.a}ngOnInit(){this._contactsService.onSelectedContactsChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{this.selectedContacts=t,setTimeout(()=>{this.hasSelectedContacts=t.length>0,this.isIndeterminate=t.length!==this._contactsService.contacts.length&&t.length>0},0)})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}selectAll(){this._contactsService.selectContacts()}deselectAll(){this._contactsService.deselectContacts()}deleteSelectedContacts(){this.confirmDialogRef=this._matDialog.open(j.a,{disableClose:!1}),this.confirmDialogRef.componentInstance.confirmMessage="Are you sure you want to delete all selected contacts?",this.confirmDialogRef.afterClosed().subscribe(t=>{t&&this._contactsService.deleteSelectedContacts(),this.confirmDialogRef=null})}}return t.\u0275fac=function(c){return new(c||t)(f.Wb(M),f.Wb(h.b))},t.\u0275cmp=f.Qb({type:t,selectors:[["selected-bar"]],decls:27,vars:2,consts:[["fxFlex","","fxLayout","row","fxLayoutAlign","start center",1,"p-24"],["fxFlex","0 1 auto","fxFlex.gt-sm","220px",1,"close-button-wrapper",3,"click"],["mat-button","","fxLayout","row","fxLayoutAlign","start center",1,"p-8"],[1,"mr-8"],[1,"text-uppercase"],["fxFlex","","fxLayout","row","fxLayoutAlign","end center","fxLayoutAlign.gt-sm","space-between center"],[1,"selected-contacts-count"],[1,"mr-4"],["mat-icon-button","",3,"matMenuTriggerFor"],["selectMenu","matMenu"],["mat-menu-item","",3,"click"],[1,"multi-select-actions"],["mat-icon-button","","aria-label","delete selected",3,"click"]],template:function(t,c){if(1&t&&(f.cc(0,"div",0),f.cc(1,"div",1),f.oc("click",(function(){return c.deselectAll()})),f.cc(2,"button",2),f.cc(3,"mat-icon",3),f.ad(4,"arrow_back"),f.bc(),f.cc(5,"span",4),f.ad(6,"Back"),f.bc(),f.bc(),f.bc(),f.cc(7,"div",5),f.cc(8,"div"),f.cc(9,"span",6),f.cc(10,"span",7),f.ad(11),f.bc(),f.cc(12,"span"),f.ad(13,"selected"),f.bc(),f.bc(),f.cc(14,"button",8),f.cc(15,"mat-icon"),f.ad(16,"arrow_drop_down"),f.bc(),f.bc(),f.cc(17,"mat-menu",null,9),f.cc(19,"button",10),f.oc("click",(function(){return c.selectAll()})),f.ad(20,"Select all"),f.bc(),f.cc(21,"button",10),f.oc("click",(function(){return c.deselectAll()})),f.ad(22,"Deselect all"),f.bc(),f.bc(),f.bc(),f.cc(23,"div",11),f.cc(24,"button",12),f.oc("click",(function(){return c.deleteSelectedContacts()})),f.cc(25,"mat-icon"),f.ad(26,"delete"),f.bc(),f.bc(),f.bc(),f.bc(),f.bc()),2&t){const t=f.Mc(18);f.Hb(11),f.bd(c.selectedContacts.length),f.Hb(3),f.zc("matMenuTriggerFor",t)}},directives:[g.b,g.e,g.d,C.b,x.a,B.c,B.d,B.a],styles:["[_nghost-%COMP%]{flex:1;position:absolute;top:0;right:0;left:0;height:120px;z-index:99}"]}),t})();function xt(t,c){1&t&&f.Xb(0,"selected-bar",18),2&t&&f.zc("@slideInTop",void 0)}const vt=function(){return{delay:"50ms",scale:"0.2"}},wt=function(t){return{value:"*",params:t}},yt=function(){return{delay:"100ms",x:"-25px"}},St=function(){return{value:"*"}},_t=function(){return{delay:"300ms",scale:".2"}};let kt=(()=>{class t{constructor(t,c,e){this._contactsService=t,this._PersoInfoSidebarService=c,this._matDialog=e,this.searchInput=new i.d(""),this._unsubscribeAll=new s.a}ngOnInit(){this._contactsService.onSelectedContactsChanged.pipe(Object(l.a)(this._unsubscribeAll)).subscribe(t=>{this.hasSelectedContacts=t.length>0}),this.searchInput.valueChanges.pipe(Object(l.a)(this._unsubscribeAll),Object(r.a)(300),Object(d.a)()).subscribe(t=>{this._contactsService.onSearchTextChanged.next(t)})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}newContact(){this.dialogRef=this._matDialog.open(A,{panelClass:"contact-form-dialog",data:{action:"new"}}),this.dialogRef.afterClosed().subscribe(t=>{t&&this._contactsService.updateContact(t.getRawValue())})}toggleSidebar(t){this._PersoInfoSidebarService.getSidebar(t).toggleOpen()}}return t.\u0275fac=function(c){return new(c||t)(f.Wb(M),f.Wb(P.a),f.Wb(h.b))},t.\u0275cmp=f.Qb({type:t,selectors:[["contacts"]],decls:28,vars:16,consts:[["id","contacts",1,"page-layout","simple","left-sidebar","inner-sidebar","inner-scroll"],["fxLayout","column","fxLayoutAlign","start start","fxLayout.gt-xs","row","fxLayoutAlign.gt-xs","space-between center",1,"header","mat-accent-bg","p-16","p-sm-24"],["fxLayout","row","fxLayoutAlign","start center"],["mat-icon-button","","fxHide.gt-md","",1,"sidebar-toggle","mr-12",3,"click"],["fxLayout","row","fxLayoutAlign","start center",1,"logo"],[1,"logo-icon","mr-16"],[1,"logo-text","h1"],["fxLayout","row","fxLayoutAlign","start center",1,"search-input-wrapper","mt-16","ml-8","m-sm-0"],["for","search",1,"mr-8"],["mat-no-float","","floatLabel","never",1,"m-0"],["matInput","","id","search","placeholder","Search for anything",3,"formControl"],["class","mat-accent-600-bg",4,"ngIf"],[1,"content"],["name","contacts-main-sidebar","position","left","lockedOpen","gt-sm",1,"sidebar"],["persoInfoPerfectScrollbar","",1,"content"],["persoInfoPerfectScrollbar","",1,"center","p-24","pb-56","pr-sm-92"],[1,"content","mat-white-bg","mat-elevation-z4"],["mat-fab","","id","add-contact-button","aria-label","add contact",1,"mat-accent-bg",3,"click"],[1,"mat-accent-600-bg"]],template:function(t,c){1&t&&(f.cc(0,"div",0),f.cc(1,"div",1),f.cc(2,"div",2),f.cc(3,"button",3),f.oc("click",(function(){return c.toggleSidebar("contacts-main-sidebar")})),f.cc(4,"mat-icon"),f.ad(5,"menu"),f.bc(),f.bc(),f.cc(6,"div",4),f.cc(7,"mat-icon",5),f.ad(8,"account_box "),f.bc(),f.cc(9,"span",6),f.ad(10," Contacts "),f.bc(),f.bc(),f.bc(),f.cc(11,"div",7),f.cc(12,"label",8),f.cc(13,"mat-icon"),f.ad(14,"search"),f.bc(),f.bc(),f.cc(15,"mat-form-field",9),f.Xb(16,"input",10),f.bc(),f.bc(),f.bc(),f.Yc(17,xt,1,1,"selected-bar",11),f.cc(18,"div",12),f.cc(19,"persoinfo-sidebar",13),f.cc(20,"div",14),f.Xb(21,"contacts-main-sidebar"),f.bc(),f.bc(),f.cc(22,"div",15),f.cc(23,"div",16),f.Xb(24,"contacts-contact-list"),f.bc(),f.bc(),f.bc(),f.bc(),f.cc(25,"button",17),f.oc("click",(function(){return c.newContact()})),f.cc(26,"mat-icon"),f.ad(27,"person_add"),f.bc(),f.bc()),2&t&&(f.Hb(7),f.zc("@animate",f.Dc(7,wt,f.Cc(6,vt))),f.Hb(2),f.zc("@animate",f.Dc(10,wt,f.Cc(9,yt))),f.Hb(7),f.zc("formControl",c.searchInput),f.Hb(1),f.zc("ngIf",c.hasSelectedContacts),f.Hb(4),f.zc("@animate",f.Cc(12,St)),f.Hb(4),f.zc("@animate",f.Dc(14,wt,f.Cc(13,_t))))},directives:[z.a,g.e,g.d,C.b,L.b,x.a,w.b,y.b,i.b,i.o,i.e,_.u,F.a,v.a,N,pt,Ct],styles:["#contacts .content{overflow:hidden}#contacts .content .sidebar:not(.locked-open){background:#fff}"],encapsulation:2,data:{animation:b.a}}),t})();e.d(c,"ContactsModule",(function(){return Ht}));const Dt=[{path:"**",component:kt,resolve:{contacts:M}}];let Ht=(()=>{class t{}return t.\u0275mod=f.Ub({type:t}),t.\u0275inj=f.Tb({factory:function(c){return new(c||t)},providers:[M],imports:[[a.j.forChild(Dt),C.c,Q.b,S.c,w.d,x.b,y.c,B.b,T.s,X.k,p.b,n.a,o.a,o.g]]}),t})()}}]);