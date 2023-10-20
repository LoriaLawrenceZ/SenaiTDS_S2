import { createRouter, createWebHistory } from 'vue-router'
import CatalogoDeFilmes from '../components/CatalogoDeFilmes.vue'
import CatalogoDeLivros from '../components/CatalogoDeLivros.vue'

const routes = [
  {
    path: '/filmes',
    name: 'CatálogodeFilmes',
    component: CatalogoDeFilmes
  },
  {
    path: '/livros',
    name: 'CatálogodeLivros',
    component: CatalogoDeLivros
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
