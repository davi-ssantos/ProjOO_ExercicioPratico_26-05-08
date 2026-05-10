# Lógica de Negócio

Este documento descreve os fluxos principais do sistema de reserva de salas, detalhando como as classes e padrões de projeto interagem para atender cada requisito funcional.

O sistema permite que estudantes e professores consultem disponibilidade de salas, façam reservas e recebam notificações sobre alterações ou conflitos. Toda interação do usuário é com `SistemaDeReservas`, que orquestra os subsistemas internos de forma transparente.