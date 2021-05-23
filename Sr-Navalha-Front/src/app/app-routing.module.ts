import { AgendamentoComponent } from './view/agendamento/agendamento.component';
import { AdminComponent } from './view/admin/admin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './view/home/home.component';
import { LoginComponent } from './view/login/login.component';
import { CadastroComponent } from './view/cadastro/cadastro.component';
import { TelaBarbeiroComponent } from './view/tela-barbeiro/tela-barbeiro.component';
import { TelaClienteComponent } from './view/tela-cliente/tela-cliente.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'agendamento', component: AgendamentoComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'telaBarbeiro', component: TelaBarbeiroComponent },
  { path: 'telaCliente', component: TelaClienteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
