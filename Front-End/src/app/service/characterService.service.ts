import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

/**
 * Clase service para consumir los servicios de Marvel
 * @BaironPerez
 */

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  private url: string = "http://localhost:8080/clientes";

  constructor(
      private http: HttpClient
  ) { }


  /** 
  * Servicio para listar los characters
  */
  getCharacters(params?: any): Observable<any> {
      return this.http.get<any>(`${this.url}/finAll`, { params: params });
  }

  /** 
  * Servicio para listar un character por su id
  */
  getCharacterById(sharedKey?: any): Observable<any> {
      return this.http.get<any>(`${this.url}/findBySharedKey/${sharedKey}`);
  }

}