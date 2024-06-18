import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CharactersComponent } from './pages/characters/characters.component';
import { UnCharacterComponent } from './pages/un-character/un-character.component';


const routes: Routes = [
  { path: '**', pathMatch: 'full', redirectTo: 'heroes' },
  { path: 'heroes', component: CharactersComponent },
  { path: 'unHeroe/:id', component: UnCharacterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
