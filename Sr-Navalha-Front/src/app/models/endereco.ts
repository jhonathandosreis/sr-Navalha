import { Cidade } from './cidade';

export class Endereco {
    id: any;
    bairro: any;
    logradouro: any;
    numero: any;
    cep: any;
    cidade: Cidade = new Cidade;
}