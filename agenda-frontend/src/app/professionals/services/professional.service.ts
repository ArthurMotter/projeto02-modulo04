import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Professional } from '../models/professional.model';

// Paginated interface
export interface Page<T> {
  content: T[];
  pageable: any;
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  sort: any;
  first: boolean;
  numberOfElements: number;
  empty: boolean;
}

// --- backend DTO ---
export interface ProfessionalRequest {
  id?: number;
  name: string;
  phone: string;
  email: string;
  active: boolean;
  areaIds: number[];
}

@Injectable({
  providedIn: 'root'
})
export class ProfessionalService {

  private readonly API_URL = 'http://localhost:8080/professionals';

  constructor(private http: HttpClient) { }

  getProfissionais(
    page: number,
    size: number,
    name: string
  ): Observable<Page<Professional>> {

    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    if (name) {
      params = params.set('name', name);
    }

    return this.http.get<Page<Professional>>(this.API_URL, { params });
  }

  // Handle both create and update
  save(data: ProfessionalRequest): Observable<Professional> {
    if (data.id) {
      // If an ID exists, it's an update (PUT)
      return this.http.put<Professional>(`${this.API_URL}/${data.id}`, data);
    } else {
      // If no ID, it's a create (POST)
      return this.http.post<Professional>(this.API_URL, data);
    }
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${id}`);
  }
}