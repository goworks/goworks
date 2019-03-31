package cc.goworks.lifeditor.tunnel.tunnels;

public interface Tunnel<T> {
    T get(String logicId);
    void save(T aDo);
}
