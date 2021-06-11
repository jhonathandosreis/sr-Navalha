import { AuthGuard } from './auth.guard';
import { UpdateAgendamentoComponent } from './view/agendamento/update-agendamento/update-agendamento.component';
import { SpinnerComponent } from './view/spinner/spinner.component';
import { AgendamentosComponent } from './view/agendamento/agendamentos/agendamentos.component';
import { ServicoComponent } from './view/servico/servico.component';
import { PortfolioComponent } from './view/portfolio/portfolio.component';
import { AgendamentoComponent } from './view/agendamento/agendamento.component';
import { AdminComponent } from './view/admin/admin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './view/home/home.component';
import { LoginComponent } from './view/login/login.component';
import { CadastroComponent } from './view/cadastro/cadastro.component';
import { TelaBarbeiroComponent } from './view/tela-barbeiro/tela-barbeiro.component';
import { TelaClienteComponent } from './view/tela-cliente/tela-cliente.component';
import { ServicoListComponent } from './view/servico/servico-list/servico-list.component';
import { PerfilClienteComponent } from './view/perfil-cliente/perfil-cliente.component';

import { ServicoListBarbeiroComponent } from './view/servico/servico-list-barbeiro/servico-list-barbeiro.component';

import { TelaClienteAdminComponent } from './view/tela-cliente/tela-cliente-admin/tela-cliente-admin.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'agendamento/novo/:id', component: AgendamentoComponent, canActivate: [AuthGuard] },
  { path: 'agendamentos', component: AgendamentosComponent, canActivate: [AuthGuard] },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] },
  { path: "agendamento/:id", component: UpdateAgendamentoComponent, canActivate: [AuthGuard] },
  { path: 'carregando', component: SpinnerComponent },
  { path: 'cadastro', component: CadastroComponent },
  {
    path: 'telaBarbeiro', component: TelaBarbeiroComponent, canActivate: [AuthGuard],
    children: [{ path: 'serv', component: ServicoComponent },
    { path: 'agend', component: AgendamentosComponent, canActivate: [AuthGuard] },
    { path: 'servlist', component: ServicoListBarbeiroComponent, canActivate: [AuthGuard] }]
  },
  {
    path: 'telaCliente', component: TelaClienteComponent,
    children: [{ path: 'serv', component: ServicoComponent, canActivate: [AuthGuard] },
    { path: 'agend', component: AgendamentosComponent, canActivate: [AuthGuard] }], canActivate: [AuthGuard]
  },
  { path: 'portfolio', component: PortfolioComponent, canActivate: [AuthGuard] },
  { path: 'servico', component: ServicoComponent, canActivate: [AuthGuard] },
  { path: 'servicoList', component: ServicoListComponent},
  { path: 'perfilCliente/:email', component: PerfilClienteComponent, canActivate: [AuthGuard] },
  { path: 'telaBarbeiro/:email', component: TelaBarbeiroComponent, canActivate: [AuthGuard] },
  { path: 'telaClienteAdmin', component: TelaClienteAdminComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
