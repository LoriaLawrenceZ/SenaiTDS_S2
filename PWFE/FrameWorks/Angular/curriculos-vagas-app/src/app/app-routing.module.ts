import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './view/inicio/inicio.component';
import { CurriculosComponent } from './view/curriculos/curriculos.component';
import { VagasComponent } from './view/vagas/vagas.component';
import { PainelVagasComponent } from './view/painel-vagas/painel-vagas.component';

const routes: Routes = [
  { path: '', component: InicioComponent }, // Rota para a página inicial
  { path: 'curriculos', component: CurriculosComponent }, // Rota para currículos
  { path: 'vagas', component: VagasComponent }, // Rota para vagas
  { path: 'painel', component: PainelVagasComponent } // Rota para painel de vagas
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
