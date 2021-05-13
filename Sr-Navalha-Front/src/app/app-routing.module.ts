import { AdminComponent } from './view/admin/admin.component';
import { NgModule } from '@angular/core';
import { Routes ,RouterModule } from '@angular/router';
import { HomeComponent } from './view/home/home.component';
import { LoginComponent } from './view/login/login.component';
import { RecuperarSenhaComponent } from './view/recuperar-senha/recuperar-senha.component';

const routes: Routes = [
  {path:'',component: HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'admin',component:AdminComponent},
  {path:'recuperarSenha',component:RecuperarSenhaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
