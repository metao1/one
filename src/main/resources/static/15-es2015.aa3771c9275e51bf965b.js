(window.webpackJsonp=window.webpackJsonp||[]).push([[15],{Sma3:function(n,t,e){"use strict";e.r(t);var o=e("tyNb"),c=e("0BIi"),i=e("2Vo4"),a=e("fXoL"),g=e("tk/3");let r=(()=>{class n{constructor(n){this._httpClient=n,this.timelineOnChanged=new i.a({}),this.aboutOnChanged=new i.a({}),this.photosVideosOnChanged=new i.a({})}resolve(n,t){return new Promise((n,t)=>{Promise.all([this.getTimeline(),this.getAbout(),this.getPhotosVideos()]).then(()=>{n()},t)})}getTimeline(){return new Promise((n,t)=>{this._httpClient.get("api/profile-timeline").subscribe(t=>{this.timeline=t,this.timelineOnChanged.next(this.timeline),n(this.timeline)},t)})}getAbout(){return new Promise((n,t)=>{this._httpClient.get("api/profile-about").subscribe(t=>{this.about=t,this.aboutOnChanged.next(this.about),n(this.about)},t)})}getPhotosVideos(){return new Promise((n,t)=>{this._httpClient.get("api/profile-photos-videos").subscribe(t=>{this.photosVideos=t,this.photosVideosOnChanged.next(this.photosVideos),n(this.photosVideos)},t)})}}return n.\u0275fac=function(t){return new(t||n)(a.kc(g.c))},n.\u0275prov=a.Sb({token:n,factory:n.\u0275fac}),n})();var s=e("HY3y"),b=e("XiUz"),d=e("bTqV"),l=e("wZkO"),m=e("XNiG"),O=e("1G5W"),_=e("NFeN"),C=e("f0Cb"),P=e("ofXK"),M=e("3Pt+");function p(n,t){1&n&&(a.cc(0,"span"),a.ad(1,"posted on your timeline"),a.bc())}function f(n,t){1&n&&(a.cc(0,"span"),a.ad(1,"shared something with you"),a.bc())}function u(n,t){1&n&&(a.cc(0,"span"),a.ad(1,"shared a video with you"),a.bc())}function x(n,t){1&n&&(a.cc(0,"span"),a.ad(1,"shared an article with you"),a.bc())}function h(n,t){if(1&n&&(a.cc(0,"div",44),a.ad(1),a.bc()),2&n){const n=a.sc().$implicit;a.Hb(1),a.cd(" ",n.message," ")}}function v(n,t){if(1&n&&a.Xb(0,"img",48),2&n){const n=a.sc(2).$implicit;a.zc("src",n.media.preview,a.Sc)}}function y(n,t){if(1&n&&a.Xb(0,"div",49),2&n){const n=a.sc(2).$implicit;a.zc("innerHtml",n.media.embed,a.Rc)}}function w(n,t){if(1&n&&(a.cc(0,"div",45),a.Yc(1,v,1,1,"img",46),a.Yc(2,y,1,1,"div",47),a.bc()),2&n){const n=a.sc().$implicit;a.Hb(1),a.zc("ngIf","image"===n.media.type),a.Hb(1),a.zc("ngIf","video"===n.media.type)}}function H(n,t){if(1&n&&(a.cc(0,"div",50),a.cc(1,"div",45),a.Xb(2,"img",48),a.bc(),a.cc(3,"div",15),a.ad(4),a.bc(),a.cc(5,"div",51),a.ad(6),a.bc(),a.cc(7,"div",52),a.ad(8),a.bc(),a.bc()),2&n){const n=a.sc().$implicit;a.Hb(2),a.zc("src",n.article.media.preview,a.Sc),a.Hb(2),a.bd(n.article.title),a.Hb(2),a.bd(n.article.subtitle),a.Hb(2),a.bd(n.article.excerpt)}}function L(n,t){if(1&n&&(a.cc(0,"div",53),a.ad(1),a.cc(2,"mat-icon",34),a.ad(3,"keyboard_arrow_down"),a.bc(),a.bc()),2&n){const n=a.sc().$implicit;a.Hb(1),a.cd(" ",n.comments.length," comments ")}}function F(n,t){if(1&n&&(a.cc(0,"div",54),a.Xb(1,"img",23),a.cc(2,"div",55),a.cc(3,"div",6),a.cc(4,"span",25),a.ad(5),a.bc(),a.cc(6,"span",27),a.ad(7),a.bc(),a.bc(),a.cc(8,"div",44),a.ad(9),a.bc(),a.cc(10,"div",56),a.cc(11,"a",57),a.ad(12,"Reply"),a.bc(),a.cc(13,"mat-icon",58),a.ad(14,"flag"),a.bc(),a.bc(),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(1),a.zc("src",n.user.avatar,a.Sc),a.Hb(4),a.bd(n.user.name),a.Hb(2),a.bd(n.time),a.Hb(2),a.cd(" ",n.message," ")}}function z(n,t){if(1&n&&(a.cc(0,"div",20),a.cc(1,"header",21),a.cc(2,"div",22),a.Xb(3,"img",23),a.cc(4,"div",24),a.cc(5,"div",15),a.cc(6,"span",25),a.ad(7),a.bc(),a.Yc(8,p,2,0,"span",26),a.Yc(9,f,2,0,"span",26),a.Yc(10,u,2,0,"span",26),a.Yc(11,x,2,0,"span",26),a.bc(),a.cc(12,"div",27),a.ad(13),a.bc(),a.bc(),a.bc(),a.cc(14,"button",28),a.cc(15,"mat-icon"),a.ad(16,"more_vert"),a.bc(),a.bc(),a.bc(),a.cc(17,"div",29),a.Yc(18,h,2,1,"div",30),a.Yc(19,w,3,2,"div",31),a.Yc(20,H,9,4,"div",32),a.cc(21,"div",6),a.cc(22,"button",33),a.cc(23,"span",6),a.cc(24,"mat-icon",34),a.ad(25,"favorite"),a.bc(),a.cc(26,"span"),a.ad(27,"Like"),a.bc(),a.ad(28,"\xa0"),a.cc(29,"span"),a.ad(30),a.bc(),a.bc(),a.bc(),a.cc(31,"button",35),a.cc(32,"span",6),a.cc(33,"mat-icon",34),a.ad(34,"share"),a.bc(),a.cc(35,"span"),a.ad(36,"Share"),a.bc(),a.ad(37,"\xa0"),a.cc(38,"span"),a.ad(39),a.bc(),a.bc(),a.bc(),a.bc(),a.bc(),a.cc(40,"footer",36),a.Yc(41,L,4,1,"div",37),a.Yc(42,F,15,4,"div",38),a.cc(43,"div",39),a.Xb(44,"img",40),a.cc(45,"form",41),a.Xb(46,"textarea",42),a.cc(47,"button",43),a.ad(48," Post Comment "),a.bc(),a.bc(),a.bc(),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(3),a.zc("src",n.user.avatar,a.Sc),a.Hb(4),a.bd(n.user.name),a.Hb(1),a.zc("ngIf","post"===n.type),a.Hb(1),a.zc("ngIf","something"===n.type),a.Hb(1),a.zc("ngIf","video"===n.type),a.Hb(1),a.zc("ngIf","article"===n.type),a.Hb(2),a.bd(n.time),a.Hb(5),a.zc("ngIf",n.message),a.Hb(1),a.zc("ngIf",n.media),a.Hb(1),a.zc("ngIf",n.article),a.Hb(10),a.cd("(",n.like,")"),a.Hb(9),a.cd("(",n.share,")"),a.Hb(2),a.zc("ngIf",n.comments),a.Hb(1),a.zc("ngForOf",n.comments)}}function A(n,t){if(1&n&&(a.cc(0,"div",59),a.Xb(1,"img",60),a.cc(2,"div",24),a.cc(3,"div"),a.cc(4,"span",25),a.ad(5),a.bc(),a.cc(6,"span",44),a.ad(7),a.bc(),a.bc(),a.cc(8,"span",61),a.ad(9),a.bc(),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(1),a.Ac("alt",n.user.name),a.zc("src",n.user.avatar,a.Sc),a.Hb(4),a.bd(n.user.name),a.Hb(2),a.cd(" ",n.message,""),a.Hb(2),a.bd(n.time)}}let k=(()=>{class n{constructor(n){this._profileService=n,this._unsubscribeAll=new m.a}ngOnInit(){this._profileService.timelineOnChanged.pipe(Object(O.a)(this._unsubscribeAll)).subscribe(n=>{this.timeline=n})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}}return n.\u0275fac=function(t){return new(t||n)(a.Wb(r))},n.\u0275cmp=a.Qb({type:n,selectors:[["profile-timeline"]],decls:30,vars:2,consts:[["id","timeline","fxLayout","row wrap",1,"p-24"],["fxLayout","column","fxFlex","100","fxFlex.gt-sm","55","fxFlex.gt-md","65",1,"timeline-content"],[1,"profile-box","add-post"],["fxFlex","",1,"form"],["placeholder","Write something.."],["fxLayout","row","fxLayoutAlign","space-between center"],["fxLayout","row","fxLayoutAlign","start center"],["mat-icon-button","","aria-label","Add photo","matTooltip","Add Photo"],["mat-icon-button","","aria-label","Mention somebody","matTooltip","Mention somebody"],["mat-icon-button","","aria-label","Add location","matTooltip","Add location"],["mat-raised-button","","color","accent","aria-label","POST",1,"post-button"],["class","timeline-item",4,"ngFor","ngForOf"],["fxLayout","column","fxFlex","100","fxFlex.gt-sm","45","fxFlex.gt-md","35",1,"timeline-sidebar"],["fxLayout","column",1,"profile-box","latest-activity"],["fxLayout","row","fxLayoutAlign","space-between center",1,"mat-accent-bg"],[1,"title"],[1,"more","secondary-text"],["fxLayout","row wrap",1,"content"],[1,"activities"],["class","activity","fxLayout","row","fxLayoutAlign","start start",4,"ngFor","ngForOf"],[1,"timeline-item"],["fxLayout","row","fxLayoutAlign","space-between start"],["fxLayout","row","fxLayoutAlign","start center",1,"user"],[1,"avatar",3,"src"],["fxLayout","column"],[1,"username"],[4,"ngIf"],[1,"time"],["mat-icon-button","","aria-label","More"],[1,"content"],["class","message",4,"ngIf"],["class","media",4,"ngIf"],["fxLayout","column","class","article",4,"ngIf"],["mat-button","",1,"like-button"],[1,"s-16"],["mat-button","",1,"share-button"],["fxLayout","column","fxLayoutAlign","start start",1,""],["class","comment-count","fxLayout","row","fxLayoutAlign","start center",4,"ngIf"],["class","comment","fxLayout","row","fxFlexFill","",4,"ngFor","ngForOf"],["fxLayout","row","fxFlexFill","",1,"reply"],["src","assets/images/avatars/profile.jpg",1,"avatar"],["fxFlex",""],["placeholder","Add a comment..."],["mat-raised-button","","color","accent","aria-label","Post Comment",1,"post-comment-button"],[1,"message"],[1,"media"],[3,"src",4,"ngIf"],[3,"innerHtml",4,"ngIf"],[3,"src"],[3,"innerHtml"],["fxLayout","column",1,"article"],[1,"subtitle"],[1,"excerpt"],["fxLayout","row","fxLayoutAlign","start center",1,"comment-count"],["fxLayout","row","fxFlexFill","",1,"comment"],["fxLayout","column","fxFlex",""],["fxLayout","row","fxLayoutAlign","space-between center",1,"actions"],["href","#",1,"reply-button"],["fxFlex","",1,"report-button","s-16"],["fxLayout","row","fxLayoutAlign","start start",1,"activity"],[1,"avatar",3,"src","alt"],[1,"time","secondary-text"]],template:function(n,t){1&n&&(a.cc(0,"div",0),a.cc(1,"div",1),a.cc(2,"div",2),a.cc(3,"div",3),a.Xb(4,"textarea",4),a.cc(5,"footer",5),a.cc(6,"div",6),a.cc(7,"button",7),a.cc(8,"mat-icon"),a.ad(9,"photo"),a.bc(),a.bc(),a.cc(10,"button",8),a.cc(11,"mat-icon"),a.ad(12,"person"),a.bc(),a.bc(),a.cc(13,"button",9),a.cc(14,"mat-icon"),a.ad(15,"location_on"),a.bc(),a.bc(),a.bc(),a.cc(16,"button",10),a.ad(17,"POST"),a.bc(),a.bc(),a.bc(),a.bc(),a.Xb(18,"mat-divider"),a.Yc(19,z,49,14,"div",11),a.bc(),a.cc(20,"div",12),a.cc(21,"div",13),a.cc(22,"header",14),a.cc(23,"div",15),a.ad(24,"Latest Activity"),a.bc(),a.cc(25,"div",16),a.ad(26,"See All"),a.bc(),a.bc(),a.cc(27,"div",17),a.cc(28,"div",18),a.Yc(29,A,10,5,"div",19),a.bc(),a.bc(),a.bc(),a.bc(),a.bc()),2&n&&(a.Hb(19),a.zc("ngForOf",t.timeline.posts),a.Hb(10),a.zc("ngForOf",t.timeline.activities))},directives:[b.e,b.b,b.d,d.b,_.a,C.a,P.t,P.u,b.f,M.x,M.p,M.q],styles:["[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]{max-width:1200px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .add-post[_ngcontent-%COMP%]{margin-bottom:0;box-shadow:0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .add-post[_ngcontent-%COMP%]   textarea[_ngcontent-%COMP%]{display:flex;flex:1 0 auto;font-size:13px;width:100%;height:140px;border:none;padding:16px;resize:vertical}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .add-post[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]{padding:8px;border-top:1px solid rgba(0,0,0,.08);background:#f3f4f5}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .add-post[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .post-button[_ngcontent-%COMP%]{margin:0;width:64px;min-width:64px;height:30px;line-height:30px;min-height:30px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   mat-divider[_ngcontent-%COMP%]{border-top-width:1px;border-top-style:solid;margin:32px 0}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]{margin-bottom:32px;overflow:hidden;border-radius:2px;background:#fff;box-shadow:0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]:last-child{margin-bottom:0}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]{padding:16px 0 8px 16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-weight:500}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]   .username[_ngcontent-%COMP%]{margin-right:2px;color:#039be5}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .time[_ngcontent-%COMP%]{color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%], [_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .message[_ngcontent-%COMP%]{padding:16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   iframe[_ngcontent-%COMP%], [_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   img[_ngcontent-%COMP%]{width:100%}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{color:inherit}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .like-button[_ngcontent-%COMP%], [_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .share-button[_ngcontent-%COMP%]{padding:4px 6px;text-transform:inherit;font-size:13px;font-weight:400;margin:0 0 16px 8px;min-width:inherit;line-height:inherit}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .like-button[_ngcontent-%COMP%]:hover, [_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .share-button[_ngcontent-%COMP%]:hover{background-color:transparent}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .like-button[_ngcontent-%COMP%]   mat-icon[_ngcontent-%COMP%], [_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .share-button[_ngcontent-%COMP%]   mat-icon[_ngcontent-%COMP%]{margin:0 8px 0 0}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]{border:1px solid rgba(0,0,0,.12);margin:16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]{padding:0;overflow:hidden;border-bottom:1px solid rgba(0,0,0,.12)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   img[_ngcontent-%COMP%]{display:block;padding:0}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-size:15px;padding:16px 16px 4px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]   .subtitle[_ngcontent-%COMP%]{padding:0 16px;color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .article[_ngcontent-%COMP%]   .excerpt[_ngcontent-%COMP%]{padding:16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]{border-top:1px solid rgba(0,0,0,.08);background-color:rgba(0,0,0,.04);padding:16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment-count[_ngcontent-%COMP%]{margin-bottom:16px;cursor:pointer}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment-count[_ngcontent-%COMP%]   mat-icon[_ngcontent-%COMP%]{margin-left:8px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]{margin-bottom:24px!important}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .username[_ngcontent-%COMP%]{font-weight:500;margin-right:4px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .message[_ngcontent-%COMP%]{color:rgba(0,0,0,.87)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .time[_ngcontent-%COMP%]{color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]{margin-top:8px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .reply-button[_ngcontent-%COMP%]{margin-right:16px;cursor:pointer;color:#039be5}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .comment[_ngcontent-%COMP%]   .actions[_ngcontent-%COMP%]   .report-button[_ngcontent-%COMP%]{margin:0;cursor:pointer}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .reply[_ngcontent-%COMP%]   form[_ngcontent-%COMP%]   textarea[_ngcontent-%COMP%]{width:100%!important;min-height:72px;padding:8px;margin-bottom:8px;font-size:13px;border:1px solid rgba(0,0,0,.12)}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-content[_ngcontent-%COMP%]   .timeline-item[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]   .reply[_ngcontent-%COMP%]   form[_ngcontent-%COMP%]   .post-comment-button[_ngcontent-%COMP%]{margin:0;text-transform:inherit;font-weight:400;padding:0 12px;min-height:30px;min-width:inherit;line-height:30px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]{padding-left:32px}@media (max-width:959px){[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]{padding:32px 0 0}}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]   .latest-activity[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]{background-color:#fff}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]   .latest-activity[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .activities[_ngcontent-%COMP%]   .activity[_ngcontent-%COMP%]{padding:16px 0}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]   .latest-activity[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .activities[_ngcontent-%COMP%]   .activity[_ngcontent-%COMP%]   .avatar[_ngcontent-%COMP%]{margin-right:16px}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]   .latest-activity[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .activities[_ngcontent-%COMP%]   .activity[_ngcontent-%COMP%]   .username[_ngcontent-%COMP%]{font-weight:500;color:#039be5}[_nghost-%COMP%]   #timeline[_ngcontent-%COMP%]   .timeline-sidebar[_ngcontent-%COMP%]   .latest-activity[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .activities[_ngcontent-%COMP%]   .activity[_ngcontent-%COMP%]   .message[_ngcontent-%COMP%]{font-weight:500}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]{margin-bottom:16px;box-shadow:0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12)}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]{padding:16px}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-size:17px}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .more[_ngcontent-%COMP%]{cursor:pointer}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]{padding:16px;background-color:#fff}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]{padding:8px;border-top:1px solid rgba(0,0,0,.08);background-color:rgba(0,0,0,.06)}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]{margin-bottom:24px}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-size:15px;font-weight:500;padding-bottom:4px}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]:last-child{margin-bottom:0}"],data:{animation:s.a}}),n})();function S(n,t){if(1&n&&(a.cc(0,"div",22),a.cc(1,"span"),a.ad(2),a.bc(),a.cc(3,"mat-icon",23),a.ad(4,"location_on"),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.bd(n)}}function Y(n,t){if(1&n&&(a.cc(0,"tr",24),a.cc(1,"td",25),a.ad(2),a.bc(),a.cc(3,"td",26),a.ad(4),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.bd(n.company),a.Hb(2),a.bd(n.date)}}function I(n,t){if(1&n&&(a.cc(0,"div",7),a.cc(1,"span"),a.ad(2),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.bd(n)}}function X(n,t){if(1&n&&(a.cc(0,"div",7),a.cc(1,"span"),a.ad(2),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.bd(n)}}function $(n,t){if(1&n&&(a.cc(0,"div",7),a.cc(1,"span"),a.ad(2),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.bd(n)}}function j(n,t){if(1&n&&(a.cc(0,"div",27),a.Xb(1,"img",28),a.bc()),2&n){const n=t.$implicit;a.Hb(1),a.zc("src",n.avatar,a.Sc)}}function V(n,t){if(1&n&&(a.cc(0,"div",29),a.cc(1,"div",30),a.Xb(2,"img",31),a.cc(3,"div"),a.cc(4,"div",32),a.ad(5),a.bc(),a.cc(6,"div",33),a.ad(7),a.bc(),a.cc(8,"div",34),a.ad(9),a.bc(),a.bc(),a.bc(),a.cc(10,"button",35),a.cc(11,"mat-icon"),a.ad(12,"more_vert"),a.bc(),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(2),a.Ac("alt",n.name),a.zc("src",n.logo,a.Sc),a.Hb(3),a.bd(n.name),a.Hb(2),a.bd(n.category),a.Hb(2),a.cd("",n.members," people")}}let T=(()=>{class n{constructor(n){this._profileService=n,this._unsubscribeAll=new m.a}ngOnInit(){this._profileService.aboutOnChanged.pipe(Object(O.a)(this._unsubscribeAll)).subscribe(n=>{this.about=n})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}}return n.\u0275fac=function(t){return new(t||n)(a.Wb(r))},n.\u0275cmp=a.Qb({type:n,selectors:[["profile-about"]],decls:87,vars:13,consts:[["id","about","fxLayout","row wrap",1,"p-24"],["fxLayout","column","fxFlex","100","fxFlex.gt-sm","50","fxFlex.gt-md","65",1,"about-content"],["fxLayout","column",1,"profile-box","info-box","general"],[1,"mat-accent-bg"],[1,"title"],[1,"content"],[1,"info-line"],[1,"info"],["class","info location","fxLayout","row","fxLayoutAlign","start center",4,"ngFor","ngForOf"],["fxLayout","column",1,"profile-box","info-box","work"],[1,"info","jobs"],["class","job",4,"ngFor","ngForOf"],["fxLayout","column",1,"profile-box","info-box","contact"],["class","info",4,"ngFor","ngForOf"],["fxLayout","column","fxFlex","100","fxFlex.gt-sm","50","fxFlex.gt-md","35",1,"about-sidebar"],["fxLayout","column",1,"profile-box","friends"],["fxLayout","row","fxLayoutAlign","space-between center",1,"mat-accent-bg"],[1,"more","secondary-text"],["fxLayout","row wrap",1,"content"],["class","friend","fxFlex","20",4,"ngFor","ngForOf"],["fxLayout","column",1,"profile-box","groups"],["class","group","fxLayout","row","fxLayoutAlign","space-between center",4,"ngFor","ngForOf"],["fxLayout","row","fxLayoutAlign","start center",1,"info","location"],[1,"s-16","ml-4"],[1,"job"],[1,"company"],[1,"date"],["fxFlex","20",1,"friend"],[3,"src"],["fxLayout","row","fxLayoutAlign","space-between center",1,"group"],["fxLayout","row","fxLayoutAlign","start center"],[1,"logo",3,"src","alt"],[1,"name"],[1,"category"],[1,"members"],["mat-icon-button","","aria-label","More"]],template:function(n,t){1&n&&(a.cc(0,"div",0),a.cc(1,"div",1),a.cc(2,"div",2),a.cc(3,"header",3),a.cc(4,"div",4),a.ad(5,"General Information"),a.bc(),a.bc(),a.cc(6,"div",5),a.cc(7,"div",6),a.cc(8,"div",4),a.ad(9,"Gender"),a.bc(),a.cc(10,"div",7),a.ad(11),a.bc(),a.bc(),a.cc(12,"div",6),a.cc(13,"div",4),a.ad(14,"Birthday"),a.bc(),a.cc(15,"div",7),a.ad(16),a.bc(),a.bc(),a.cc(17,"div",6),a.cc(18,"div",4),a.ad(19,"Locations"),a.bc(),a.Yc(20,S,5,1,"div",8),a.bc(),a.cc(21,"div",6),a.cc(22,"div",4),a.ad(23,"About Me"),a.bc(),a.cc(24,"div",7),a.ad(25),a.bc(),a.bc(),a.bc(),a.bc(),a.cc(26,"div",9),a.cc(27,"header",3),a.cc(28,"div",4),a.ad(29,"Work"),a.bc(),a.bc(),a.cc(30,"div",5),a.cc(31,"div",6),a.cc(32,"div",4),a.ad(33,"Occupation"),a.bc(),a.cc(34,"div",7),a.ad(35),a.bc(),a.bc(),a.cc(36,"div",6),a.cc(37,"div",4),a.ad(38,"Skills"),a.bc(),a.cc(39,"div",7),a.ad(40),a.bc(),a.bc(),a.cc(41,"div",6),a.cc(42,"div",4),a.ad(43,"Jobs"),a.bc(),a.cc(44,"table",10),a.Yc(45,Y,5,2,"tr",11),a.bc(),a.bc(),a.bc(),a.bc(),a.cc(46,"div",12),a.cc(47,"header",3),a.cc(48,"div",4),a.ad(49,"Contact"),a.bc(),a.bc(),a.cc(50,"div",5),a.cc(51,"div",6),a.cc(52,"div",4),a.ad(53,"Address"),a.bc(),a.cc(54,"div",7),a.ad(55),a.bc(),a.bc(),a.cc(56,"div",6),a.cc(57,"div",4),a.ad(58,"Tel."),a.bc(),a.Yc(59,I,3,1,"div",13),a.bc(),a.cc(60,"div",6),a.cc(61,"div",4),a.ad(62,"Website"),a.bc(),a.Yc(63,X,3,1,"div",13),a.bc(),a.cc(64,"div",6),a.cc(65,"div",4),a.ad(66,"Emails"),a.bc(),a.Yc(67,$,3,1,"div",13),a.bc(),a.bc(),a.bc(),a.bc(),a.cc(68,"div",14),a.cc(69,"div",15),a.cc(70,"header",16),a.cc(71,"div",4),a.ad(72,"Friends"),a.bc(),a.cc(73,"div",17),a.cc(74,"span"),a.ad(75,"See 454 more..."),a.bc(),a.bc(),a.bc(),a.cc(76,"div",18),a.Yc(77,j,2,1,"div",19),a.bc(),a.bc(),a.cc(78,"div",20),a.cc(79,"header",16),a.cc(80,"div",4),a.ad(81,"Joined Groups"),a.bc(),a.cc(82,"div",17),a.cc(83,"span"),a.ad(84,"See 6 more..."),a.bc(),a.bc(),a.bc(),a.cc(85,"div",5),a.Yc(86,V,13,5,"div",21),a.bc(),a.bc(),a.bc(),a.bc()),2&n&&(a.Hb(11),a.bd(t.about.general.gender),a.Hb(5),a.bd(t.about.general.birthday),a.Hb(4),a.zc("ngForOf",t.about.general.locations),a.Hb(5),a.bd(t.about.general.about),a.Hb(10),a.bd(t.about.work.occupation),a.Hb(5),a.bd(t.about.work.skills),a.Hb(5),a.zc("ngForOf",t.about.work.jobs),a.Hb(10),a.bd(t.about.contact.address),a.Hb(4),a.zc("ngForOf",t.about.contact.tel),a.Hb(4),a.zc("ngForOf",t.about.contact.websites),a.Hb(4),a.zc("ngForOf",t.about.contact.emails),a.Hb(10),a.zc("ngForOf",t.about.friends),a.Hb(9),a.zc("ngForOf",t.about.groups))},directives:[b.e,b.b,P.t,b.d,_.a,d.b],styles:["[_nghost-%COMP%]   #about[_ngcontent-%COMP%]{max-width:1200px}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-content[_ngcontent-%COMP%]   .general[_ngcontent-%COMP%]   .location[_ngcontent-%COMP%]   mat-icon[_ngcontent-%COMP%]{line-height:13px!important}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-content[_ngcontent-%COMP%]   .work[_ngcontent-%COMP%]   .job[_ngcontent-%COMP%]   .company[_ngcontent-%COMP%]{padding:0 16px 0 0;font-weight:500}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-content[_ngcontent-%COMP%]   .work[_ngcontent-%COMP%]   .job[_ngcontent-%COMP%]   .date[_ngcontent-%COMP%]{color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]{padding-left:32px}@media screen and (min-width:600px) and (max-width:959px){[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]{padding:8px}}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .friends[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .friend[_ngcontent-%COMP%]{padding:4px}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]{margin-bottom:16px}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]:last-child{margin-bottom:0}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]   .logo[_ngcontent-%COMP%]{border:1px solid rgba(0,0,0,.12);margin-right:16px}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]   .name[_ngcontent-%COMP%]{font-weight:500;font-size:15px}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]   .category[_ngcontent-%COMP%], [_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]   .members[_ngcontent-%COMP%]{color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #about[_ngcontent-%COMP%]   .about-sidebar[_ngcontent-%COMP%]   .groups[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]   .group[_ngcontent-%COMP%]   .members[_ngcontent-%COMP%]{margin-top:16px}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]{margin-bottom:16px;box-shadow:0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12)}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]{padding:16px}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-size:17px}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   header[_ngcontent-%COMP%]   .more[_ngcontent-%COMP%]{cursor:pointer}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   .content[_ngcontent-%COMP%]{padding:16px;background-color:#fff}[_nghost-%COMP%]   .profile-box[_ngcontent-%COMP%]   footer[_ngcontent-%COMP%]{padding:8px;border-top:1px solid rgba(0,0,0,.08);background-color:rgba(0,0,0,.06)}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]{margin-bottom:24px}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{font-size:15px;font-weight:500;padding-bottom:4px}[_nghost-%COMP%]   .profile-box.info-box[_ngcontent-%COMP%]   .info-line[_ngcontent-%COMP%]:last-child{margin-bottom:0}"],data:{animation:s.a}}),n})();function W(n,t){if(1&n&&(a.cc(0,"div",8),a.Xb(1,"img",9),a.cc(2,"div",10),a.ad(3),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(1),a.Ac("title",n.title),a.zc("src",n.preview,a.Sc),a.Hb(2),a.bd(n.title)}}function D(n,t){if(1&n&&(a.cc(0,"div",2),a.cc(1,"div",3),a.cc(2,"span",4),a.ad(3),a.bc(),a.cc(4,"span",5),a.ad(5),a.bc(),a.bc(),a.cc(6,"div",6),a.Yc(7,W,4,3,"div",7),a.bc(),a.bc()),2&n){const n=t.$implicit;a.Hb(3),a.bd(n.name),a.Hb(2),a.bd(n.info),a.Hb(2),a.zc("ngForOf",n.media)}}let G=(()=>{class n{constructor(n){this._profileService=n,this._unsubscribeAll=new m.a}ngOnInit(){this._profileService.photosVideosOnChanged.pipe(Object(O.a)(this._unsubscribeAll)).subscribe(n=>{this.photosVideos=n})}ngOnDestroy(){this._unsubscribeAll.next(),this._unsubscribeAll.complete()}}return n.\u0275fac=function(t){return new(t||n)(a.Wb(r))},n.\u0275cmp=a.Qb({type:n,selectors:[["profile-photos-videos"]],decls:2,vars:1,consts:[["id","photos-videos",1,"p-24"],["class","period",4,"ngFor","ngForOf"],[1,"period"],[1,"period-title"],[1,"name"],[1,"info"],["fxLayout","row wrap",1,"period-media"],["class","media",4,"ngFor","ngForOf"],[1,"media"],[1,"preview",3,"src","title"],[1,"title"]],template:function(n,t){1&n&&(a.cc(0,"div",0),a.Yc(1,D,8,3,"div",1),a.bc()),2&n&&(a.Hb(1),a.zc("ngForOf",t.photosVideos))},directives:[P.t,b.e],styles:["[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-title[_ngcontent-%COMP%]{margin-bottom:24px}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-title[_ngcontent-%COMP%]   .name[_ngcontent-%COMP%]{font-size:20px}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-title[_ngcontent-%COMP%]   .info[_ngcontent-%COMP%]{margin-left:16px;font-size:15px;color:rgba(0,0,0,.54)}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-media[_ngcontent-%COMP%]{margin-bottom:16px}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-media[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]{margin:0 16px 16px 0;position:relative}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-media[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   .preview[_ngcontent-%COMP%]{width:256px;height:256px;display:block}[_nghost-%COMP%]   #photos-videos[_ngcontent-%COMP%]   .period[_ngcontent-%COMP%]   .period-media[_ngcontent-%COMP%]   .media[_ngcontent-%COMP%]   .title[_ngcontent-%COMP%]{position:absolute;bottom:0;left:0;right:0;z-index:10;padding:0 16px;height:48px;line-height:48px;background:rgba(0,0,0,.54);color:#fff;font-size:15px}"],data:{animation:s.a}}),n})();const J=function(){return{delay:"50ms",scale:"0.2"}},N=function(n){return{value:"*",params:n}},Q=function(){return{delay:"100ms",x:"-25px"}},q=function(){return{delay:"200ms"}};let B=(()=>{class n{constructor(){}}return n.\u0275fac=function(t){return new(t||n)},n.\u0275cmp=a.Qb({type:n,selectors:[["profile"]],decls:19,vars:12,consts:[["id","profile",1,"page-layout","simple","tabbed"],["fxLayout","column","fxLayoutAlign","center center","fxLayout.gt-sm","row","fxLayoutAlign.gt-sm","space-between end",1,"header","p-24"],["fxLayout","column","fxLayoutAlign","center center","fxLayout.gt-sm","row","fxLayoutAlign.gt-sm","start center",1,"user-info"],["src","assets/images/avatars/katherine.jpg",1,"profile-image","avatar","huge"],[1,"name"],["fxLayout","row","fxLayoutAlign","end center",1,"actions"],["mat-raised-button","","color","accent","aria-label","Follow"],["mat-raised-button","","color","primary","aria-label","Send Message"],[1,"content"],["dynamicHeight","true"],["label","Timeline"],["label","About"],["label","Photos & Videos"]],template:function(n,t){1&n&&(a.cc(0,"div",0),a.cc(1,"div",1),a.cc(2,"div",2),a.Xb(3,"img",3),a.cc(4,"div",4),a.ad(5,"Katherine Wilson "),a.bc(),a.bc(),a.cc(6,"div",5),a.cc(7,"button",6),a.ad(8,"Follow"),a.bc(),a.cc(9,"button",7),a.ad(10,"Send Message"),a.bc(),a.bc(),a.bc(),a.cc(11,"div",8),a.cc(12,"mat-tab-group",9),a.cc(13,"mat-tab",10),a.Xb(14,"profile-timeline"),a.bc(),a.cc(15,"mat-tab",11),a.Xb(16,"profile-about"),a.bc(),a.cc(17,"mat-tab",12),a.Xb(18,"profile-photos-videos"),a.bc(),a.bc(),a.bc(),a.bc()),2&n&&(a.Hb(3),a.zc("@animate",a.Dc(4,N,a.Cc(3,J))),a.Hb(1),a.zc("@animate",a.Dc(7,N,a.Cc(6,Q))),a.Hb(2),a.zc("@animate",a.Dc(10,N,a.Cc(9,q))))},directives:[b.e,b.d,d.b,l.b,l.a,k,T,G],styles:["#profile .header{height:320px;min-height:320px;max-height:320px;background:url(/assets/images/backgrounds/dark-material-bg.jpg) no-repeat 0 45%;background-size:cover}#profile .header .profile-image{margin-right:24px}@media screen and (min-width:600px) and (max-width:959px){#profile .header .profile-image{margin:0 0 16px}}#profile .header .name{font-size:34px;color:#fff}@media screen and (min-width:600px) and (max-width:959px){#profile .header .name{margin-bottom:32px}}#profile .header .actions button{text-transform:none;padding:0 16px;height:32px;line-height:32px;margin:0 0 0 8px}#profile .content{flex:1}#profile .content mat-tab-group{height:100%}#profile .content mat-tab-group .mat-tab-body-wrapper{flex-grow:1}"],encapsulation:2,data:{animation:s.a}}),n})();e.d(t,"ProfileModule",(function(){return R}));const K=[{path:"profile",component:B,resolve:{profile:r}}];let R=(()=>{class n{}return n.\u0275mod=a.Ub({type:n}),n.\u0275inj=a.Tb({factory:function(t){return new(t||n)},providers:[r],imports:[[o.j.forChild(K),d.c,C.b,_.b,l.c,c.a]]}),n})()}}]);