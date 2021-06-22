import { UsuarioCliente } from './usuario-cliente';
import { Servico } from "./servico";
import { Endereco } from './endereco';

class Agendamento {
    id: any;
    data!: any;
    horario: any;
    status: any;
    endereco!: any;
    servico!: any;
    cliente!: any
}

export { Agendamento };