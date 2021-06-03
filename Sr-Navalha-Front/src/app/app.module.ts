import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule } from '@angular/common/http';
import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './view/login/login.component';
import { HomeComponent } from './view/home/home.component';
import { FooterComponent } from './view/footer/footer.component';
import { HeaderComponent } from './view/header/header.component';
import { AdminComponent } from './view/admin/admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgendamentoComponent } from './view/agendamento/agendamento.component';
import { AuthInterceptor } from './http.interceptor';
import { CadastroComponent } from './view/cadastro/cadastro.component';
import { TelaClienteComponent } from './view/tela-cliente/tela-cliente.component';
import { TelaBarbeiroComponent } from './view/tela-barbeiro/tela-barbeiro.component';
import { ServicoComponent } from './view/servico/servico.component';
import { PortfolioComponent } from './view/portfolio/portfolio.component';
import { AgendamentosComponent } from './view/agendamento/agendamentos/agendamentos.component';
import { ServicoListComponent } from './view/servico/servico-list/servico-list.component';
import { SpinnerComponent } from './view/spinner/spinner.component';
import { UpdateAgendamentoComponent } from './view/agendamento/update-agendamento/update-agendamento.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    AdminComponent,
    AgendamentoComponent,
    CadastroComponent,
    TelaClienteComponent,
    TelaBarbeiroComponent,
    ServicoComponent,
    PortfolioComponent,
    AgendamentosComponent,
    ServicoListComponent,
    SpinnerComponent,
    UpdateAgendamentoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }, { provide: LOCALE_ID, useValue: 'pt-Br' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
