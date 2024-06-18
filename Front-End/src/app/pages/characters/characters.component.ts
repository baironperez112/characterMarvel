import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CharacterService } from 'src/app/service/characterService.service';

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.css']
})
export class CharactersComponent implements OnInit {


  characters: any[] = [];

  constructor(
    private charactersService: CharacterService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.charactersService.getCharacters().subscribe(resp => {
      this.characters = resp.data;
    });
  }


  /**
   * Metodo encardado de redireccionar a la info de un heroe de marvel
   * @param id: Identificador del heroe
   */
  unHeroe(id: number) {
    this.router.navigate(['/unHeroe', id]);
  }

}
