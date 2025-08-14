import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'profissionais',
        loadChildren: () => import('./professionals/professionals').then(m => m.ProfessionalsModule)
    }
];